package application.model;

import com.fasterxml.jackson.annotation.JsonView;

import application.entities.Joueur;
import application.views.Views;

public class InscriptionAngular {

	@JsonView(Views.Common.class)
	private Joueur joueur;
	@JsonView(Views.Common.class)
	private Integer nbPlaces;
	
	public InscriptionAngular () {
		
	}

	public InscriptionAngular(Joueur joueur, Integer nbPlaces) {
		this.joueur = joueur;
		this.nbPlaces = nbPlaces;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joueur == null) ? 0 : joueur.hashCode());
		result = prime * result + ((nbPlaces == null) ? 0 : nbPlaces.hashCode());
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
		InscriptionAngular other = (InscriptionAngular) obj;
		if (joueur == null) {
			if (other.joueur != null)
				return false;
		} else if (!joueur.equals(other.joueur))
			return false;
		if (nbPlaces == null) {
			if (other.nbPlaces != null)
				return false;
		} else if (!nbPlaces.equals(other.nbPlaces))
			return false;
		return true;
	}
	
	
}
