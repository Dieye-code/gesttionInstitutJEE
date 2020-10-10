package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entitie.Classe;
import metier.entitie.Etudiant;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */
@Local
public interface IEtudiant {
	
	public int addEtudiant(Etudiant etudiant);
	public int editEtudiant(Etudiant etudiant);
	public Etudiant getEtudiant(int idEtudiant);
	public Etudiant getEtudiantByMatricule(String matricule);
	public List<Etudiant> listeEtudiant();
	public List<Classe> listeClasse();
	public Classe getClasse(int idClasse);

}
