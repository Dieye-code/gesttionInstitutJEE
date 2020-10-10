package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entitie.AnneeAcademie;
import metier.entitie.Classe;
import metier.entitie.Enseigner;
import metier.entitie.Matiere;
import metier.entitie.Professeur;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Stateless

public class EnseignerDao implements IEnseigner {
	
	@PersistenceContext(name = "gestionInstitutPU")
	private EntityManager em;

	public EnseignerDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addEnseigner(Enseigner enseigner) {
		em.persist(enseigner);
		em.flush();
		return 1;
	}

	@Override
	public int editEnseigner(Enseigner enseigner) {
		em.persist(enseigner);
		em.flush();
		return 1;
	}

	@Override
	public Enseigner getEnseigner(int idProfesseur, int idClasse, int idMatiere, int idAnneeAcademie) {
		Query query = em.createQuery("select e from Enseigner e where e.professeur.id=:idProfesseur AND e.classe.id=:idClasse AND e.anneeAcademie.id=:idAnneeAcademie");
		query.setParameter("idProfesseur:", idProfesseur);
		query.setParameter("idClasse:", idClasse);
		query.setParameter("idAnneeAcademie:", idAnneeAcademie);
		return (Enseigner) query.getSingleResult();
	}

	@Override
	public Professeur getProfesseur(int idProfesseur) {
		return em.find(Professeur.class, idProfesseur);
	}

	@Override
	public Classe getClasse(int idClasse) {
		return em.find(Classe.class, idClasse);
	}

	@Override
	public Matiere getMatiere(int idMatiere) {
		return em.find(Matiere.class, idMatiere);
	}

	@Override
	public AnneeAcademie getAnneeAcademie(int idAnneeAcademie) {
		return em.find(AnneeAcademie.class, idAnneeAcademie);
	}

	@Override
	public List<Professeur> listeProfesseur() {
		Query query = em.createQuery("select p from Professeur p");
		return query.getResultList();
	}

	@Override
	public List<Classe> listeClasse() {
		Query query = em.createQuery("select c from classe c");
		return query.getResultList();
	}

	@Override
	public List<Matiere> listeMatiere() {
		Query query = em.createQuery("select m from Matiere m");
		return query.getResultList();
	}

	@Override
	public List<AnneeAcademie> listeAnneeAcademie() {
		Query query = em.createQuery("select a from AnneeAcademie a");
		return query.getResultList();
	}

}
