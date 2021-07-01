package application.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import application.entities.Joueur;
import application.entities.Lieu;
import application.entities.Message;
import application.views.Views;

public class RencontreAngular {
			@JsonView(Views.Common.class)
			private Integer id;
			@JsonView(Views.Common.class)
		    private String nom;
			@JsonView(Views.Common.class)
		    private LocalDate date;
			@JsonView(Views.Common.class)
		    private Lieu lieu;
			@JsonView(Views.Common.class)
		    private Integer nbPlaces;
			@JsonView(Views.Common.class)
		    private List<InscriptionAngular> inscriptions;
			@JsonView(Views.Common.class)
		    private Joueur proprio;
		    private List<Message> messages;
		    
		    public RencontreAngular() {}

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

			public Integer getNbPlaces() {
				return nbPlaces;
			}

			public void setNbPlaces(Integer nbPlaces) {
				this.nbPlaces = nbPlaces;
			}

			public List<InscriptionAngular> getInscriptions() {
				return inscriptions;
			}

			public void setInscriptions(List<InscriptionAngular> inscriptions) {
				this.inscriptions = inscriptions;
			}

			public Joueur getProprio() {
				return proprio;
			}

			public void setProprio(Joueur proprio) {
				this.proprio = proprio;
			}

			public List<Message> getMessages() {
				return messages;
			}

			public void setMessages(List<Message> messages) {
				this.messages = messages;
			}
		    
		    
		    

}
