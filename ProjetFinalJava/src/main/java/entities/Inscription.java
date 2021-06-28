package entities;

public class Inscription {

	private Joueur joueur;
	private Rencontre rencontre;
	private int placesReservees;
	
	public Inscription() {
		
	}

	public Inscription(Joueur joueur, Rencontre rencontre, int placesReservees) {
		this.joueur = joueur;
		this.rencontre = rencontre;
		this.placesReservees = placesReservees;
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
	
	
	
	
}
