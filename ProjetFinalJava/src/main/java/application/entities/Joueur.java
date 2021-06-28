package application.entities;

import java.nio.MappedByteBuffer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import application.views.Views;


@Entity
@SequenceGenerator(name = "seqJoueur", sequenceName = "seq_joueur", initialValue = 100, allocationSize = 1)
public class Joueur {
	
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqJoueur")
	private Integer id;
	
	@JsonView(Views.Common.class)
	@Column(name = "nom", length = 100, nullable = false)
	@NotEmpty(message = "le nom ne peut pas etre vide")
	@Size(min = 2)
	private String nom;
	
	@JsonView(Views.Common.class)
	@Column(name = "prenom", length = 100, nullable = false)
	@NotEmpty(message = "le prenom ne peut pas etre vide")
	@Size(min = 2)
	private String prenom;
	
	@JsonView(Views.Common.class)
	@Column(name = "NumeroTelephone")
	private int numTel;
	
	@OneToOne
	@JsonView(Views.Common.class)
	@JoinColumn(name = "id_poste", foreignKey = @ForeignKey(name = "joueur_id_poste_fk"))
	private String poste;
	
	@OneToOne
	@JsonView(Views.JoueurWithCompte.class)
	@JoinColumn(name = "id_compte", foreignKey = @ForeignKey(name = "joueur_id_compte_fk"))
	private Compte compte;
	
	@JsonView(Views.JoueurWithRencontre.class)
	@OneToOne(mappedBy = "Joueur")
	private Rencontre rencontre;
	
	aa
	@OneToMany(mappedBy = "joueur")
	private EquipeKey key;
	
	@OneToOne(mappedBy = "joueur")
	@JsonView(Views.InscriptionWithJoueur.class)
	private Inscription inscription;
	
	@OneToMany(mappedBy = "joueur")
	private Message message;
	
	public Joueur() {
		
	}
	public Joueur(Integer id, String nom, String prenom, int numTel) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
	}
	public Joueur(Integer id, String nom, String prenom, int numTel, String poste, Compte compte) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.poste = poste;
		this.compte = compte;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compte == null) ? 0 : compte.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numTel;
		result = prime * result + ((poste == null) ? 0 : poste.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Joueur other = (Joueur) obj;
		if (compte == null) {
			if (other.compte != null)
				return false;
		} else if (!compte.equals(other.compte))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return true;
	}
	
	
	
	
	
}
