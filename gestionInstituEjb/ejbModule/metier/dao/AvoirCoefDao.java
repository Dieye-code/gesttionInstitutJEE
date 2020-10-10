package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entitie.AvoirCoef;
import metier.entitie.Classe;
import metier.entitie.Matiere;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Stateless
public class AvoirCoefDao implements IAvoirCoef {

	@PersistenceContext(name = "gestionInstitutPU")
	private EntityManager em;
	
	public AvoirCoefDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addAvoirCoef(AvoirCoef avoirCoef) {
		em.persist(avoirCoef);
		em.flush();
		return 1;
	}

	@Override
	public int editAvoirCoef(AvoirCoef avoirCoef) {
		em.persist(avoirCoef);
		em.flush();
		return 1;
	}

	@Override
	public AvoirCoef getAvoirCoef(int idClasse, int idMatiere) {
		Query query = em.createQuery("select a from AvoirCoef a where a.idClasse =idClasse AND a.matiere.id = idMatiere");
		return (AvoirCoef) query.getSingleResult();
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
	public List<Classe> listeClasse() {
		Query query = em.createQuery("select c from classe c");
		return query.getResultList();
	}

	@Override
	public List<Matiere> listeMatiere() {
		Query query = em.createQuery("select m from Matiere m");
		return query.getResultList();
	}

}
