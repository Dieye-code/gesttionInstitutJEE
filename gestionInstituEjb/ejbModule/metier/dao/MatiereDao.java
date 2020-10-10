package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entitie.Matiere;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Stateless
public class MatiereDao implements IMatiere {

	@PersistenceContext(name = "gestionInstitutPU")
	private EntityManager em;
	
	public MatiereDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addMatiere(Matiere matiere) {
		em.persist(matiere);
		em.flush();
		return matiere.getId();
	}

	@Override
	public int editMatiere(Matiere matiere) {
		em.persist(matiere);
		em.flush();
		return matiere.getId();
	}

	@Override
	public Matiere getMatiere(int idMatiere) {
		return em.find(Matiere.class, idMatiere);
	}

	@Override
	public List<Matiere> listeMatiere() {
		Query query = em.createQuery("select m from Matiere m");
		return query.getResultList();
	}

}
