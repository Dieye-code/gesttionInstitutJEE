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
@Table(name = "avoirCoef")

public class AvoirCoef implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	private Classe classe;@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	private Matiere matiere;
	@Column(nullable = false)
	private int coef;
	
	private static final long serialVersionUID = 1L;

	public AvoirCoef() {
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
	 * @return the coef
	 */
	public int getCoef() {
		return coef;
	}

	/**
	 * @param coef the coef to set
	 */
	public void setCoef(int coef) {
		this.coef = coef;
	}

}
