package application.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import application.views.Views;


@Entity
@SequenceGenerator(name = "seqJoueur", sequenceName = "seq_joueur", initialValue = 100, allocationSize = 1)
public class Joueur extends Compte{
		
	@JsonView(Views.Common.class)
	@Column(name = "nom", length = 100,nullable=false)
	@NotEmpty(message = "le nom ne peut pas etre vide")
	@Size(min = 2)
	private String nom;
	
	@JsonView(Views.Common.class)
	@Column(name = "prenom", length = 100, nullable=false)
	@NotEmpty(message = "le prenom ne peut pas etre vide")
	@Size(min = 2)
	private String prenom;
	
	@JsonView(Views.Common.class)
	@Column(name = "NumeroTelephone")
	private int numTel;
	
	@JsonView(Views.Common.class)
	@Column(name = "poste")
	private String poste;
	
	@JsonView(Views.JoueurWithRencontre.class)
	@OneToMany(mappedBy = "proprio")
	private List<Rencontre> rencontre;
	
	@OneToMany(mappedBy = "key.joueur")
	@JsonView(Views.InscriptionWithJoueur.class)
	private List<Inscription> inscription;
	
	@OneToMany(mappedBy = "joueur")
	@JsonView(Views.MessageWithJoueur.class)
	private List<Message> message;
	
	public Joueur() {
		
	}

	public Joueur(@NotEmpty(message = "le nom ne peut pas etre vide") @Size(min = 2) String nom,
			@NotEmpty(message = "le prenom ne peut pas etre vide") @Size(min = 2) String prenom, int numTel,
			String poste, List<Rencontre> rencontre, List<Inscription> inscription, List<Message> message) {
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.poste = poste;
		this.rencontre = rencontre;
		this.inscription = inscription;
		this.message = message;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public List<Rencontre> getRencontre() {
		return rencontre;
	}

	public void setRencontre(List<Rencontre> rencontre) {
		this.rencontre = rencontre;
	}

	public List<Inscription> getInscription() {
		return inscription;
	}

	public void setInscription(List<Inscription> inscription) {
		this.inscription = inscription;
	}

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((inscription == null) ? 0 : inscription.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numTel;
		result = prime * result + ((poste == null) ? 0 : poste.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((rencontre == null) ? 0 : rencontre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (inscription == null) {
			if (other.inscription != null)
				return false;
		} else if (!inscription.equals(other.inscription))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numTel != other.numTel)
			return false;
		if (poste == null) {
			if (other.poste != null)
				return false;
		} else if (!poste.equals(other.poste))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (rencontre == null) {
			if (other.rencontre != null)
				return false;
		} else if (!rencontre.equals(other.rencontre))
			return false;
		return true;
	}
		
	
	
	
}
