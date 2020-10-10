package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entitie.AnneeAcademie;
import metier.entitie.Classe;
import metier.entitie.Enseigner;
import metier.entitie.Matiere;
import metier.entitie.Professeur;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */
@Local
public interface IEnseigner {
	
	public int addEnseigner(Enseigner enseigner);
	public int editEnseigner(Enseigner enseigner);
	public Enseigner getEnseigner(int idProfesseur, int idClasse,int idMatiere,int idAnneeAcademie);
	public Professeur getProfesseur(int idProfesseur);
	public Classe getClasse(int idClasse);
	public Matiere getMatiere(int idMatiere);
	public AnneeAcademie getAnneeAcademie(int idAnneeAcademie);
	public List<Professeur> listeProfesseur();
	public List<Classe> listeClasse();
	public List<Matiere> listeMatiere();
	public List<AnneeAcademie> listeAnneeAcademie();

}
