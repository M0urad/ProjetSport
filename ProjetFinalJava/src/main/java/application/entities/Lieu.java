package application.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;

import application.views.Views;


@Embeddable
public class Lieu {

	@JsonView(Views.Common.class)
	@NotEmpty
	private String nom;
	@JsonView(Views.Common.class)
	@NotNull
	private int numero;
	@JsonView(Views.Common.class)
	@Column(name = "rue", length = 200)
	@NotEmpty
	private String voie;
	@JsonView(Views.Common.class)
	@Column(name = "ville", length = 150)
	@NotEmpty
	private String ville;
	@JsonView(Views.Common.class)
	@Column(name = "code_postal", length = 20)
	@NotEmpty
	private String cp;
	
	public Lieu() {
	}
	public Lieu(String nom, int numero, String voie, String ville, String cp) {
		this.nom = nom;
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numero;
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		result = prime * result + ((voie == null) ? 0 : voie.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lieu other = (Lieu) obj;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numero != other.numero)
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		if (voie == null) {
			if (other.voie != null)
				return false;
		} else if (!voie.equals(other.voie))
			return false;
		return true;
	}
	
	
}
