package application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import application.views.Views;

@Entity
@SequenceGenerator(name = "seqInscription", sequenceName = "seq_inscription", initialValue = 100, allocationSize = 1)
public class Inscription {

	@Id
	@GeneratedValue(generator = "seqInscription", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@JsonView(Views.Common.class)
	@OneToOne
	@JoinColumn(name = "id_joueur", foreignKey = @ForeignKey(name = "inscription_id_joueur_fk"))
	private Joueur joueur;
	@JsonView(Views.Common.class)
	@OneToOne
	@JoinColumn(name = "id_rencontre", foreignKey = @ForeignKey(name = "inscription_id_rencontre_fk"))
	private Rencontre rencontre;
	@JsonView(Views.Common.class)
	@Column(name = "places_booked", length = 100, nullable = false)
	private int placesReservees;
	
	public Inscription() {
		
	}

	public Inscription(Integer id, Joueur joueur, Rencontre rencontre, int placesReservees) {
		this.id = id;
		this.joueur = joueur;
		this.rencontre = rencontre;
		this.placesReservees = placesReservees;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Rencontre getRencontre() {
		return rencontre;
	}

	public void setRencontre(Rencontre rencontre) {
		this.rencontre = rencontre;
	}

	public int getPlacesReservees() {
		return placesReservees;
	}

	public void setPlacesReservees(int placesReservees) {
		this.placesReservees = placesReservees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joueur == null) ? 0 : joueur.hashCode());
		result = prime * result + placesReservees;
		result = prime * result + ((rencontre == null) ? 0 : rencontre.hashCode());
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
		Inscription other = (Inscription) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (joueur == null) {
			if (other.joueur != null)
				return false;
		} else if (!joueur.equals(other.joueur))
			return false;
		if (placesReservees != other.placesReservees)
			return false;
		if (rencontre == null) {
			if (other.rencontre != null)
				return false;
		} else if (!rencontre.equals(other.rencontre))
			return false;
		return true;
	}
	
	
	
	
}
