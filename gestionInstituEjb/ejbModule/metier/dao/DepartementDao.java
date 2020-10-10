package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entitie.Departement;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Stateless
public class DepartementDao implements IDepartement {
	
	@PersistenceContext(name = "gestionInstitutPU")
	private EntityManager em;

	public DepartementDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addDepartement(Departement departement) {
		em.persist(departement);
		em.flush();
		return departement.getId();
	}

	@Override
	public int editDepartement(Departement departement) {
		em.merge(departement);
		em.flush();
		return departement.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departement> listeDepartement() {
		Query query = em.createQuery("select d from Departement d");
		return query.getResultList();
	}

	@Override
	public Departement getDepartement(int idDepartement) {
		
		return em.find(Departement.class, idDepartement);
	}
	
	@Override
	public Departement getDepartement(String libelle) {
		
		Query query = em.createQuery("select d from Departement d where d.libelle=:libelle");
		query.setParameter("libelle", libelle);
		return (Departement) query.getSingleResult();
	}

}
