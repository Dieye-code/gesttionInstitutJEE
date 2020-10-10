package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entitie.Matiere;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */
@Local
public interface IMatiere {
	
	public int addMatiere(Matiere matiere);
	public int editMatiere(Matiere matiere);
	public Matiere getMatiere(int idMatiere);
	public List<Matiere> listeMatiere();
	
}
