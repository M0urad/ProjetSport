package application.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class InscriptionKey implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="ik_joueur_id", foreignKey=@ForeignKey(name="inscription_joueur_id_fk"))
	private Joueur joueur;
	
	@ManyToOne
	@JoinColumn(name="ik_rencontre_id", foreignKey=@ForeignKey(name="inscription_rencontre_id_fk"))
	private Rencontre rencontre;
	
	public InscriptionKey () {
		
	}

	public InscriptionKey(Joueur joueur, Rencontre rencontre) {
		this.joueur = joueur;
		this.rencontre = rencontre;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joueur == null) ? 0 : joueur.hashCode());
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
		InscriptionKey other = (InscriptionKey) obj;
		if (joueur == null) {
			if (other.joueur != null)
				return false;
		} else if (!joueur.equals(other.joueur))
			return false;
		if (rencontre == null) {
			if (other.rencontre != null)
				return false;
		} else if (!rencontre.equals(other.rencontre))
			return false;
		return true;
	}

	
}
