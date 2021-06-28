package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class EquipeKey implements Serializable{

	@ManyToOne
	@JoinColumn(name = "joueur_id",foreignKey=@ForeignKey(name="joueur_id_fk"))
	private List<Joueur> joueurs;

	
	public EquipeKey() {
	}
	
	public EquipeKey(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joueurs == null) ? 0 : joueurs.hashCode());
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
		EquipeKey other = (EquipeKey) obj;
		if (joueurs == null) {
			if (other.joueurs != null)
				return false;
		} else if (!joueurs.equals(other.joueurs))
			return false;
		return true;
	}
	
	
	

}
