package application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import application.views.Views;


@Entity

@SequenceGenerator(name = "seqMessage", sequenceName = "seq_message", initialValue = 10, allocationSize = 1)
public class Message {
	@JsonView(Views.Common.class)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduit")
	private Integer id;
	
	@JsonView(Views.Common.class)
	private String commentaire;
	@ManyToOne
	@JsonView(Views.Common.class)
	@JoinColumn(name = "id_joueur", foreignKey = @ForeignKey(name = "message_id_joueur_fk"))
	private Joueur joueur;

	public Message() {
	}


	public String getCommentaire() {
		return commentaire;
	}

	public Message(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public Message(Integer id, String commentaire, Joueur joueur) {
		this.id = id;
		this.commentaire = commentaire;
		this.joueur = joueur;
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


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentaire == null) ? 0 : commentaire.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joueur == null) ? 0 : joueur.hashCode());
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
		Message other = (Message) obj;
		if (commentaire == null) {
			if (other.commentaire != null)
				return false;
		} else if (!commentaire.equals(other.commentaire))
			return false;
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
		return true;
	}

	
	
}
