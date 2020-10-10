package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entitie.AvoirCoef;
import metier.entitie.Classe;
import metier.entitie.Matiere;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */
@Local
public interface IAvoirCoef {
	
	public int addAvoirCoef(AvoirCoef avoirCoef);
	public int editAvoirCoef(AvoirCoef avoirCoef);
	public AvoirCoef getAvoirCoef(int idClasse, int idMatiere);
	public Classe getClasse(int idClasse);
	public Matiere getMatiere(int idMatiere);
	public List<Classe> listeClasse();
	public List<Matiere> listeMatiere();
	
}
