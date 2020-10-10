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
@Table(name = "enseigner")

public class Enseigner implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "idClasse", nullable = false)
	private Classe classe;
	@Id
	@ManyToOne
	@JoinColumn(name = "idProfesseur", nullable = false)
	private Professeur professeur;
	@Id
	@ManyToOne
	@JoinColumn(name = "idmatiere", nullable = false)
	private Matiere matiere;
	@Id
	@ManyToOne
	@JoinColumn(name = "idAnneeAcademie", nullable = false)
	private AnneeAcademie anneeAcademie;
	@Column(nullable = false)
	private int nombreH;
	
	private static final long serialVersionUID = 1L;

	public Enseigner() {
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
	 * @return the professeur
	 */
	public Professeur getProfesseur() {
		return professeur;
	}

	/**
	 * @param professeur the professeur to set
	 */
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	/**
	 * @return the matiere
	 */
	public Matiere getMatiere() {
		return matiere;
	}

	/**
	 * @param matiere the matiere to set
	 */
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
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
	 * @return the nombreH
	 */
	public int getNombreH() {
		return nombreH;
	}

	/**
	 * @param nombreH the nombreH to set
	 */
	public void setNombreH(int nombreH) {
		this.nombreH = nombreH;
	}

}
