package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entitie.Departement;
import metier.entitie.Filiere;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */
@Local
public interface IFiliere {
	
	public int addFiliere(Filiere filiere);
	public int editFiliere(Filiere filiere);
	public Filiere getFiliere(int idFiliere);
	public List<Filiere> listeFiliere();
	public Departement getDepartement(int idDepartement);
	public List<Departement> listeDepartement();

}
