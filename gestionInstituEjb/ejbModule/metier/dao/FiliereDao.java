package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entitie.Departement;
import metier.entitie.Filiere;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Stateless
public class FiliereDao implements IFiliere {

	@PersistenceContext( name= "gestionInstitutPU")
	private EntityManager em;
	
	public FiliereDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addFiliere(Filiere filiere) {
		em.persist(filiere);
		em.flush();
		return filiere.getId();
	}

	@Override
	public int editFiliere(Filiere filiere) {
		em.merge(filiere);
		em.flush();
		return filiere.getId();
	}

	@Override
	public Filiere getFiliere(int idFiliere) {
		
		return em.find(Filiere.class, idFiliere);
	}

	@Override
	public List<Filiere> listeFiliere() {
		Query query = em.createQuery("select f from Filiere f");
		return query.getResultList();
	}

	@Override
	public Departement getDepartement(int idDepartement) {
		
		return em.find(Departement.class, idDepartement);
	}

	@Override
	public List<Departement> listeDepartement() {
		Query query = em.createQuery("select d from Departement d");
		return query.getResultList();
	}

}
