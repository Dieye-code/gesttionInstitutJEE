package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entitie.AnneeAcademie;
import metier.entitie.Classe;
import metier.entitie.Enseigner;
import metier.entitie.Etudiant;
import metier.entitie.Inscrire;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Stateless
public class InscrireDao implements IInscrire {
	
	@PersistenceContext(name = "gestionInstitutPU")
	private EntityManager em;

	public InscrireDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addInscrire(Inscrire inscrire) {
		em.persist(inscrire);
		em.flush();
		return 1;
	}

	@Override
	public int editInscrire(Inscrire inscrire) {
		em.persist(inscrire);
		em.flush();
		return 1;
	}

	@Override
	public Inscrire getInscrire(int idEtudiant, int idClasse, int idAnneeAcademie) {
		Query query = em.createQuery("select e from Inscrire e where e.etudiant.id=:idEtudiant AND e.classe.id=:idClasse AND e.anneeAcademie.id=:idAnneeAcademie");
		query.setParameter("idEtudiant:", idEtudiant);
		query.setParameter("idClasse:", idClasse);
		query.setParameter("idAnneeAcademie:", idAnneeAcademie);
		return (Inscrire) query.getSingleResult();
	}

	@Override
	public Classe getClasse(int idClasse) {
		return em.find(Classe.class, idClasse);
	}

	@Override
	public Etudiant getEtudiant(int idEtudiant) {
		return em.find(Etudiant.class, idEtudiant);
	}

	@Override
	public AnneeAcademie getAnneeAcademie(int idAnneeAcademie) {
		return em.find(AnneeAcademie.class, idAnneeAcademie);
	}

	@Override
	public List<Classe> listeClasse() {
		Query query = em.createQuery("select c from classe c");
		return query.getResultList();
	}

	@Override
	public List<Etudiant> listeEtudiant() {
		Query query = em.createQuery("select c from Etudiant c");
		return query.getResultList();
	}

	@Override
	public List<AnneeAcademie> listeAnneeAcademie() {
		Query query = em.createQuery("select a from AnneeAcademie a");
		return query.getResultList();
	}

}
