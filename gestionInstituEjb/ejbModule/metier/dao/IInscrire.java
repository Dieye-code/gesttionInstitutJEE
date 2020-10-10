package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entitie.AnneeAcademie;
import metier.entitie.Classe;
import metier.entitie.Etudiant;
import metier.entitie.Inscrire;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Local
public interface IInscrire {
	
	public int addInscrire(Inscrire inscrire);
	public int editInscrire(Inscrire inscrire);
	public Inscrire getInscrire(int idEtudiant, int idClasse, int idAnneeAcademie);
	public Classe getClasse(int idClasse);
	public Etudiant getEtudiant(int idEtudiant);
	public AnneeAcademie getAnneeAcademie(int idAnneeAcademie);
	public List<Classe> listeClasse();
	public List<Etudiant> listeEtudiant();
	public List<AnneeAcademie> listeAnneeAcademie();

}
