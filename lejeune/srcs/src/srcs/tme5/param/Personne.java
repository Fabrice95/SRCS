package srcs.tme5.param;

import java.io.Serializable;
import java.rmi.Remote;

public class Personne implements Remote {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String numero;
	
	private String prenom;
	private String adresse;
	private int compteurRecherche;
	
	public Personne(String nom, String prenom, String numero, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.adresse = adresse;
		this.compteurRecherche = 0;
	}

	public String getNom() {
		return nom;
	}

	public String getNumero() {
		return numero;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getCompteurRecherche() {
		return compteurRecherche;
	}
	
	public void recherche() {
		compteurRecherche++;
	}
}
