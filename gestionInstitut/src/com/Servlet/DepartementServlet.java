package com.Servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.IDepartement;
import metier.entitie.Departement;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

/**
 * Servlet implementation class DepartementServlet
 */
@WebServlet(name = "departement", urlPatterns = { "/Departement", "/Departement/add", "Departement/edit/*" })
public class DepartementServlet extends HttpServlet {

	@EJB
	private IDepartement departement;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * On utilise la méthode doGet pour traiter les requettes Get
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("base_url", "http://localhost:8080/gestionInstitut/");
		String methode = request.getRequestURI();
		if (methode.endsWith("/add")) { //Ajout d'un Departement
			
			this.getServletContext().getRequestDispatcher("/departement/add.jsp").forward(request, response);
		} else if (methode.contains("/edit")) { //Modification d'un departement

			String[] dept = request.getRequestURI().split("/");
			try {
				int a = Integer.parseInt(dept[dept.length - 1]);
				request.setAttribute("departement", departement.getDepartement(a));
			} catch (Exception e) {

				request.setAttribute("departement", null);
			}
			this.getServletContext().getRequestDispatcher("/departement/edit.jsp").forward(request, response);
		} else { //Liste des Departements

			request.setAttribute("departements", departement.listeDepartement());

			this.getServletContext().getRequestDispatcher("/departement/liste.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("base_url", "http://localhost:8080/gestionInstitut/");

		String methode = request.getRequestURI();
		if (methode.endsWith("/add")) {
			//traitement a faire si on envoie les donnees pour ajouter un Departement
			if (request.getParameter("libelle").trim() == "") {
				request.setAttribute("vide", 1);
				this.getServletContext().getRequestDispatcher("/departement/add.jsp").forward(request, response);
			} else {
				Departement dept = new Departement();
				try {
					dept = departement.getDepartement(request.getParameter("libelle"));
				} catch (Exception e) {
					dept = null;
				}
				if (dept != null) {
					request.setAttribute("existe", 1);
					request.setAttribute("libelle", dept.getLibelle());
					this.getServletContext().getRequestDispatcher("/departement/add.jsp").forward(request, response);
				} else {
					dept = new Departement();
					dept.setLibelle(request.getParameter("libelle"));
					int a = departement.addDepartement(dept);
					request.setAttribute("a", a);

					request.setAttribute("departements", departement.listeDepartement());

					this.getServletContext().getRequestDispatcher("/departement/liste.jsp").forward(request, response);
				}

			}

		} else if (methode.contains("/edit")) { 
			//Modification des information du departement avec la methode post
			String[] chaine = request.getRequestURI().split("/");
			try {
				int a = Integer.parseInt(chaine[chaine.length - 1]);
				request.setAttribute("departement", departement.getDepartement(a));
			} catch (Exception e) {

				request.setAttribute("departement", null);
			}
			if (request.getAttribute("departement") == null) {
				this.getServletContext().getRequestDispatcher("/departement/edit.jsp").forward(request, response);
			} else {
				if (request.getParameter("libelle").trim() == "") {
					request.setAttribute("vide", 1);
					this.getServletContext().getRequestDispatcher("/departement/edit.jsp").forward(request, response);
				} else {
					Departement dept = new Departement();
					try {
						dept = departement.getDepartement(request.getParameter("libelle"));
					} catch (Exception e) {
						dept = null;
					}
					if (dept != null && ((Departement) request.getAttribute("departement")).getId() != dept.getId()) {
						request.setAttribute("existe", 1);
						request.setAttribute("libelle", ((Departement) request.getAttribute("departement")).getLibelle());
						this.getServletContext().getRequestDispatcher("/departement/edit.jsp").forward(request,
								response);
					} else {
						dept.setLibelle(request.getParameter("libelle"));
						int a = departement.editDepartement(dept);
						request.setAttribute("a", a);

						request.setAttribute("departements", departement.listeDepartement());

						this.getServletContext().getRequestDispatcher("/departement/liste.jsp").forward(request,
								response);
					}

				}
			}

		}
	}

}
