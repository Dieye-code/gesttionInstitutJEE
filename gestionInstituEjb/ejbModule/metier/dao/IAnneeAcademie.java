package metier.dao;


import java.util.List;

import javax.ejb.Local;

import metier.entitie.AnneeAcademie;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */
@Local
public interface IAnneeAcademie {
	
	public int addAnneeAcademie(AnneeAcademie anneeAcademie);
	public int editAnneeAcademie(AnneeAcademie anneeAcademie);
	public AnneeAcademie getAnneeAcademie(int idAnneeAcademie);
	public List<AnneeAcademie> listeAnneeAcademie();
	

}
