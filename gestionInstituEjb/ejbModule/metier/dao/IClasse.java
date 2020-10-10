package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entitie.Classe;
import metier.entitie.Filiere;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */
@Local
public interface IClasse {
	
	public int addClasse(Classe classe);
	public int editClasse(Classe classe);
	public Classe getClasse(int idClasse);
	public List<Classe> listeClasse();
	public Filiere getFiliere(int idFiliere);
	public List<Filiere> listeFiliere();

}
