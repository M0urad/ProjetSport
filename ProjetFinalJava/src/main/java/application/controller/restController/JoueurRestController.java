package application.controller.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import application.entities.Joueur;
import application.exceptions.JoueurException;
import application.exceptions.rest.JoueurInvalidException;
import application.services.JoueurService;
import application.views.Views;

@RestController
@RequestMapping("/api/joueur")
@CrossOrigin(origins = "*")
public class JoueurRestController {

	@Autowired
	private JoueurService joueurService;
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Joueur> getAllJoueur(){
		return getAll();
	}
	
	@GetMapping("/rencontre")
	@JsonView(Views.JoueurWithRencontre.class)
	public List<Joueur> getAllJoueurWithRencontre(){
		return getAll();
	}
	
	private List<Joueur> getAll(){
		return joueurService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Joueur getJoueurById(@PathVariable Integer id) {
		return getById(id);
	}
	
	@GetMapping("/{id}/rencontre")
	@JsonView(Views.JoueurWithRencontre.class)
	public Joueur getJoueurWithRencontreById(Integer id) {
		return getById(id);
	}
	
	private Joueur getById(Integer id) {
		Joueur joueur = joueurService.getById(id);
		if (joueur.getId()==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return joueur;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		joueurService.delete(id);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Views.Common.class)
	public Joueur create(@RequestBody @Valid Joueur joueur, BindingResult br) {
		if (br.hasErrors()) {
			throw new JoueurInvalidException();
		}
		try {
//			joueur.getUtilisateur().setPassword(passwordEncoder.encode(joueur.getUtilisateur().getPassword()));
			joueur = joueurService.save(joueur);
		} catch (JoueurException e) {
			throw new JoueurInvalidException();
		}
		return joueur;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Joueur update(@RequestBody @Valid Joueur client, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new JoueurInvalidException();
		}
//		client.setId(id);
//		if (!client.getUtilisateur().getPassword().isEmpty()) {
//			client.getUtilisateur().setPassword(passwordEncoder.encode(client.getUtilisateur().getPassword()));
//		}
		try {
			client = joueurService.save(client);
		} catch (JoueurException e) {
			throw new JoueurInvalidException();
		}
		return client;
	}
	
}
