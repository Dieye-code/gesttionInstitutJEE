package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entitie.Professeur;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Stateless
public class ProfesseurDao implements IProfesseur {
	
	@PersistenceContext(name = "gestionInstitutPU")
	private EntityManager em;

	public ProfesseurDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addProfesseur(Professeur professeur) {
		em.persist(professeur);
		em.flush();
		return professeur.getId();
	}

	@Override
	public int editProfesseur(Professeur professeur) {
		em.persist(professeur);
		em.flush();
		return professeur.getId();
	}

	@Override
	public Professeur getProfesseur(int idProfesseur) {
		return em.find(Professeur.class, idProfesseur);
	}

	@Override
	public List<Professeur> listeProfesseur() {
		Query query = em.createQuery("select c from Professeur c");
		return query.getResultList();
		
		
	}

}
