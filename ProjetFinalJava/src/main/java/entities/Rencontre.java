package entities;

import java.time.LocalDate;
import java.util.List;

public class Rencontre {

	private Integer id;
	private String name;
	private LocalDate date;
	private Lieu lieu;
	private Equipe list;
	private Joueur arbitre;
	private int nbPlaces;
	private List<Inscription> listInscription;
	private Joueur proprio;
	private List<Message> listMessages;
	
	public Rencontre() {
		
	}

	public Rencontre(Integer id, String name, LocalDate date, Lieu lieu, Equipe list, Joueur arbitre, int nbPlaces,
			List<Inscription> listInscription, Joueur proprio, List<Message> listMessages) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.lieu = lieu;
		this.list = list;
		this.arbitre = arbitre;
		this.nbPlaces = nbPlaces;
		this.listInscription = listInscription;
		this.proprio = proprio;
		this.listMessages = listMessages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public Equipe getList() {
		return list;
	}

	public void setList(Equipe list) {
		this.list = list;
	}

	public Joueur getArbitre() {
		return arbitre;
	}

	public void setArbitre(Joueur arbitre) {
		this.arbitre = arbitre;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public List<Inscription> getListInscription() {
		return listInscription;
	}

	public void setListInscription(List<Inscription> listInscription) {
		this.listInscription = listInscription;
	}

	public Joueur getProprio() {
		return proprio;
	}

	public void setProprio(Joueur proprio) {
		this.proprio = proprio;
	}

	public List<Message> getListMessages() {
		return listMessages;
	}

	public void setListMessages(List<Message> listMessages) {
		this.listMessages = listMessages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arbitre == null) ? 0 : arbitre.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((listInscription == null) ? 0 : listInscription.hashCode());
		result = prime * result + ((listMessages == null) ? 0 : listMessages.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nbPlaces;
		result = prime * result + ((proprio == null) ? 0 : proprio.hashCode());
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
		Rencontre other = (Rencontre) obj;
		if (arbitre == null) {
			if (other.arbitre != null)
				return false;
		} else if (!arbitre.equals(other.arbitre))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (listInscription == null) {
			if (other.listInscription != null)
				return false;
		} else if (!listInscription.equals(other.listInscription))
			return false;
		if (listMessages == null) {
			if (other.listMessages != null)
				return false;
		} else if (!listMessages.equals(other.listMessages))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nbPlaces != other.nbPlaces)
			return false;
		if (proprio == null) {
			if (other.proprio != null)
				return false;
		} else if (!proprio.equals(other.proprio))
			return false;
		return true;
	}
	
	
	
}
