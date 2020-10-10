package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entitie.Classe;
import metier.entitie.Etudiant;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Stateless
public class EtudiantDao implements IEtudiant {
	
	@PersistenceContext(name = "gestionInstitutPU")
	private EntityManager em;

	public EtudiantDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addEtudiant(Etudiant etudiant) {
		em.persist(etudiant);
		em.flush();
		return etudiant.getId();
	}

	@Override
	public int editEtudiant(Etudiant etudiant) {
		em.persist(etudiant);
		em.flush();
		return etudiant.getId();
	}

	@Override
	public Etudiant getEtudiant(int idEtudiant) {
		return em.find(Etudiant.class, idEtudiant);
	}

	@Override
	public Etudiant getEtudiantByMatricule(String matricule) {
		Query query = em.createQuery("select e from Etudiant e where e.matricule=matricule");
		return (Etudiant) query.getSingleResult();
	}

	@Override
	public List<Etudiant> listeEtudiant() {
		Query query = em.createQuery("select e from Etudiant e");
		return query.getResultList();
	}

	@Override
	public List<Classe> listeClasse() {
		Query query = em.createQuery("select c from classe c");
		return query.getResultList();
	}

	@Override
	public Classe getClasse(int idClasse) {
		return em.find(Classe.class, idClasse);
	}

}
