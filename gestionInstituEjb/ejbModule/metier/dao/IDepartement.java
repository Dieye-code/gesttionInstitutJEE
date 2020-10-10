package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entitie.Departement;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */
@Local
public interface IDepartement {
	
	public int addDepartement(Departement departement);
	public int editDepartement(Departement departement);
	public List<Departement> listeDepartement();
	public Departement getDepartement(int idDepartement);
	public Departement getDepartement(String libelle);

}
