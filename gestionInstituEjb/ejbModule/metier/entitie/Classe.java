package metier.entitie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Entity
@Table(name="classe")
public class Classe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private int montantInscription;
	private int mensualite;
	@ManyToOne
	private Filiere filiere;
	private static final long serialVersionUID = 1L;
	
	

	public Classe() {
		super();
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}



	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	/**
	 * @return the montantInscription
	 */
	public int getMontantInscription() {
		return montantInscription;
	}



	/**
	 * @param montantInscription the montantInscription to set
	 */
	public void setMontantInscription(int montantInscription) {
		this.montantInscription = montantInscription;
	}



	/**
	 * @return the mensualite
	 */
	public int getMensualite() {
		return mensualite;
	}



	/**
	 * @param mensualite the mensualite to set
	 */
	public void setMensualite(int mensualite) {
		this.mensualite = mensualite;
	}



	/**
	 * @return the filiere
	 */
	public Filiere getFiliere() {
		return filiere;
	}



	/**
	 * @param filiere the filiere to set
	 */
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

}
