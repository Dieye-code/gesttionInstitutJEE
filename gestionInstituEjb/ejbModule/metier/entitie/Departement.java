package metier.entitie;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
 
/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */


/**
 * Entity implementation class for Entity: Departement
 *
 */
@Entity
@Table(name = "departement")

public class Departement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "departement")
	private List<Filiere> filieres;

	public Departement() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the filieres
	 */
	public List<Filiere> getFilieres() {
		return filieres;
	}

	/**
	 * @param filieres the filieres to set
	 */
	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}
	
	/**
	 * @param filiere 
	 */
	public void addFiliere(Filiere filiere) {
		if(!this.filieres.contains(filiere)) {
			this.filieres.add(filiere);
		}
	}

}
