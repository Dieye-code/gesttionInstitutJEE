package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entitie.Professeur;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Local
public interface IProfesseur {
	
	public int addProfesseur(Professeur professeur);
	public int editProfesseur(Professeur professeur);
	public Professeur getProfesseur(int idProfesseur);
	public List<Professeur> listeProfesseur();
	

}
