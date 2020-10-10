package metier.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entitie.Classe;
import metier.entitie.Filiere;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Stateless
public class ClasseDao implements IClasse {
	
	@PersistenceContext( name= "gestionInstitutPU")
	private EntityManager em ;

	public ClasseDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addClasse(Classe classe) {
		em.persist(classe);
		em.flush();
		return classe.getId();
	}

	@Override
	public int editClasse(Classe classe) {
		em.merge(classe);
		em.flush();
		return classe.getId();
	}

	@Override
	public Classe getClasse(int idClasse) {
		
		return em.find(Classe.class, idClasse);
	}

	@Override
	public List<Classe> listeClasse() {
		Query query = em.createQuery("select c from Classe c");
		return query.getResultList();
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

}
