package metier.entitie;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Entity
@Table(name = "inscrire")

public class Inscrire implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "idClasse", nullable = false)
	private Classe classe;
	@Id
	@ManyToOne
	@JoinColumn(name = "idEtudiant", nullable = false)
	private Etudiant etudiant;
	@Id
	@ManyToOne
	@JoinColumn(name = "idAnneeAcademie", nullable = false)
	private AnneeAcademie anneeAcademie;
	@Column(nullable = false)
	private String dateInscription;
	
	private static final long serialVersionUID = 1L;

	public Inscrire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the classe
	 */
	public Classe getClasse() {
		return classe;
	}

	/**
	 * @param classe the classe to set
	 */
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	/**
	 * @return the etudiant
	 */
	public Etudiant getEtudiant() {
		return etudiant;
	}

	/**
	 * @param etudiant the etudiant to set
	 */
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	/**
	 * @return the anneeAcademie
	 */
	public AnneeAcademie getAnneeAcademie() {
		return anneeAcademie;
	}

	/**
	 * @param anneeAcademie the anneeAcademie to set
	 */
	public void setAnneeAcademie(AnneeAcademie anneeAcademie) {
		this.anneeAcademie = anneeAcademie;
	}

	/**
	 * @return the dateInscription
	 */
	public String getDateInscription() {
		return dateInscription;
	}

	/**
	 * @param dateInscription the dateInscription to set
	 */
	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}

}
