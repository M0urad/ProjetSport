package application.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import application.views.Views;


@Entity
@SequenceGenerator(name = "seqRencontre", sequenceName = "seq_rencontre", initialValue = 100, allocationSize = 1)
public class Rencontre {
	
	@JsonView(Views.Common.class)
	@Id
	@Column(name = "id_rencontre")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRencontre")
	private Integer id;
	
	@JsonView(Views.Common.class)
	@Column(name = "nom_rencontre", length = 100, nullable = false)
	private String name;
	
	@JsonView(Views.Common.class)
	@Column(name = "date_rencontre")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@JsonView(Views.Common.class)
	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name = "nom_lieuRencontre", column = @Column(name = "nom_lieuRencontre")),
		@AttributeOverride(name = "numero", column = @Column(name = "street_number")),
		@AttributeOverride(name = "rue", column = @Column(name = "street", length = 150)),
		@AttributeOverride(name = "codePostal", column = @Column(name = "zip_code", length = 30)),
		@AttributeOverride(name = "ville", column = @Column(name = "city", length = 200)) })
	private Lieu lieu;
	
	@OneToOne
	@JsonView(Views.RencontreWithEquipe.class)
	@JoinColumn(name = "id_equipe1", foreignKey = @ForeignKey(name = "rencontre_id_equipe1_fk"))
	private Equipe equipe1;
	
	@OneToOne
	@JsonView(Views.RencontreWithEquipe.class)
	@JoinColumn(name = "id_equipe2", foreignKey = @ForeignKey(name = "rencontre_id_equipe2_fk"))
	private Equipe equipe2;
	
	@OneToOne(mappedBy = "rencontre")
	@JsonView(Views.RencontreWithJoueur.class)
	@JoinColumn(name = "id_arbitre", foreignKey = @ForeignKey(name = "rencontre_id_arbitre_fk"))
	private Joueur arbitre;
	
	@JsonView(Views.Common.class)
	@Column(name = "nombre_places", nullable = false)
	private int nbPlaces;
	
	@JsonIgnore
	@OneToOne(mappedBy = "rencontre")
	private List<Inscription> listInscription;
	
	@JsonView(Views.RencontreWithJoueur.class)
	@OneToOne
	@JoinColumn(name = "id_proprio", foreignKey = @ForeignKey(name = "rencontre_id_proprio_fk"))
	private Joueur proprio;
	
	@OneToMany(mappedBy = "rencontre")
	@JsonIgnore
	private List<Message> listMessages;

	public Rencontre() {

	}

	public Rencontre(Integer id, String name, LocalDate date, Lieu lieu, Equipe equipe1, Equipe equipe2, Joueur arbitre,
			int nbPlaces, List<Inscription> listInscription, Joueur proprio, List<Message> listMessages) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.lieu = lieu;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
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

	public Equipe getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
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
		result = prime * result + ((equipe1 == null) ? 0 : equipe1.hashCode());
		result = prime * result + ((equipe2 == null) ? 0 : equipe2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
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
		if (equipe1 == null) {
			if (other.equipe1 != null)
				return false;
		} else if (!equipe1.equals(other.equipe1))
			return false;
		if (equipe2 == null) {
			if (other.equipe2 != null)
				return false;
		} else if (!equipe2.equals(other.equipe2))
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
