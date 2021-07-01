package application.controller.restController;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

import application.config.CompteSpring;
import application.entities.Inscription;
import application.entities.InscriptionKey;
import application.entities.Joueur;
import application.entities.Rencontre;
import application.exceptions.InscriptionException;
import application.exceptions.rest.InscriptionInvalidException;
import application.model.InscriptionAngular;
import application.services.InscriptionService;
import application.services.JoueurService;
import application.services.RencontreService;
import application.views.Views;

@RestController
@RequestMapping("/api/inscription")
@CrossOrigin(origins = "*")
public class InscriptionRestController {
	
	@Autowired
	private InscriptionService inscriptionService;
	@Autowired
	private RencontreService rencontreService;
	@Autowired
	private JoueurService joueurService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Inscription> getAllInscription() {
		return getAll();
	}

	private List<Inscription> getAll() {
		return inscriptionService.getAll();
	}
	
	@GetMapping("/ang/{idRencontre}")
	@JsonView(Views.Common.class)
	public List<InscriptionAngular> getAllAng(@PathVariable Integer idRencontre) {
		List<InscriptionAngular> insAngList = new ArrayList();
		List<Inscription> inscriptions = inscriptionService.getByRencontre(idRencontre);
		for(Inscription ins : inscriptions) {
			InscriptionAngular insAng = new InscriptionAngular();
			insAng.setJoueur(ins.getKey().getJoueur());
			insAng.setNbPlaces(ins.getPlacesReservees());
			insAngList.add(insAng);
		}		
		return insAngList;
	}

	
	

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Inscription getInscriptionById(@PathVariable Integer id) {
		return getById(id);
	}

	private Inscription getById(Integer id) {
		Inscription inscription = inscriptionService.getById(id);
		if (inscription.getKey() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return inscription;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		inscriptionService.deleteById(id);
	}
	
	@DeleteMapping("/{inscription}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Inscription inscription) {
		inscriptionService.delete(inscription);
	}

	@PostMapping("/inscKey_renc/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Views.Common.class)
	public Inscription create(@RequestBody @Valid Inscription inscription, BindingResult br, @AuthenticationPrincipal CompteSpring compteSpring,@PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new InscriptionInvalidException();
		}
		Rencontre rencontre = rencontreService.getById(id);
		try {
			//inscription.getUtilisateur().setPassword(passwordEncoder.encode(inscription.getUtilisateur().getPassword()));
			InscriptionKey inscKey= new InscriptionKey( );
			inscKey.setJoueur((Joueur)compteSpring.getCompte());
			inscKey.setRencontre(rencontre);
			inscription.setKey(inscKey);
			
			inscription = inscriptionService.save(inscription);
		} catch (InscriptionException e) {
			throw new InscriptionInvalidException();
		}
		return inscription;
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Inscription update(@RequestBody @Valid Inscription inscription, BindingResult br, @PathVariable InscriptionKey id) {
		if (br.hasErrors()) {
			throw new InscriptionInvalidException();
		}
		inscription.setKey(id);
//		if (!inscription.getUtilisateur().getPassword().isEmpty()) {
//			inscription.getUtilisateur().setPassword(passwordEncoder.encode(inscription.getUtilisateur().getPassword()));
//		}
		try {
			
			inscription = inscriptionService.save(inscription);
		} catch (InscriptionException e) {
			throw new InscriptionInvalidException();
		}
		return inscription;
	}

}
