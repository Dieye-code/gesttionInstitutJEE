package metier.entitie;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Moustapha Dieye <moustaphadieye96@gmail.com>
 *
 */

@Entity

@Table(name="filiere")

public class Filiere implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	@ManyToOne
	private Departement departement;
	@OneToMany(mappedBy = "filiere")
	private List<Classe> classes;

	public Filiere() {
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
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}

	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	/**
	 * @return the classes
	 */
	public List<Classe> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	
	/**
	 * @param classe	Ajout d'une Classe
	 */
	public void addClasse(Classe classe) {
		if(!this.classes.contains(classe)) {
			this.classes.add(classe);
		}
	}

}
