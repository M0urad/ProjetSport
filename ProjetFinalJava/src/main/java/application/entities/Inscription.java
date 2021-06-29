package application.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonView;

import application.views.Views;

@Entity
public class Inscription {

	@EmbeddedId
	private InscriptionKey key;
	
	@JsonView(Views.Common.class)
	@Column(name = "places_booked", length = 100, nullable = false)
	private int placesReservees;
	
	public Inscription() {
		
	}

	public Inscription(InscriptionKey key, int placesReservees) {
		this.key = key;
		this.placesReservees = placesReservees;
	}

	public InscriptionKey getKey() {
		return key;
	}

	public void setKey(InscriptionKey key) {
		this.key = key;
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
		result = prime * result + placesReservees;
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
		if (placesReservees != other.placesReservees)
			return false;
		return true;
	}

	
	
	
}
