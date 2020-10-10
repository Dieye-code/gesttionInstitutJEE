package metier.dao;

import java.util.List;

import javax.ejb.Remote;

import metier.entitie.Departement;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */
@Remote
public interface IDepartementRemote {
	
	public int addDepartement(Departement departement);
	public int editDepartement(Departement departement);
	public List<Departement> listeDepartement();
	public Departement getDepartement(int idDepartement);

}
