package metier.entitie;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Entity
@Table(name="professeur")

public class Professeur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idPersonne" ,nullable = false)
	private Personne personne;
	private static final long serialVersionUID = 1L;

	public Professeur() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the personne
	 */
	public Personne getPersonne() {
		return personne;
	}

	/**
	 * @param personne the personne to set
	 */
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}
