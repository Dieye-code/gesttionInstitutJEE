package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entitie.AnneeAcademie;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Stateless
public class AnneeAcademieDao implements IAnneeAcademie {
	
	@PersistenceContext(name= "gestionInstitutPU")
	private EntityManager em;

	public AnneeAcademieDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addAnneeAcademie(AnneeAcademie anneeAcademie) {
		em.persist(anneeAcademie);
		em.flush();
		return anneeAcademie.getId();
	}

	@Override
	public int editAnneeAcademie(AnneeAcademie anneeAcademie) {
		em.merge(anneeAcademie);
		em.flush();
		return anneeAcademie.getId();
	}

	@Override
	public AnneeAcademie getAnneeAcademie(int idAnneeAcademie) {
		return em.find(AnneeAcademie.class, idAnneeAcademie);
	}

	@Override
	public List<AnneeAcademie> listeAnneeAcademie() {
		Query query = em.createQuery("select a from AnneeAcademie a");
		return query.getResultList();
	}

}
