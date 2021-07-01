package application.controller.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import application.entities.Compte;
import application.exceptions.CompteException;
import application.exceptions.rest.CompteInvalidException;
import application.services.CompteService;
import application.views.Views;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = "*")
public class CompteRestController {

	@Autowired
	private CompteService compteService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Compte> getAllCompte() {
		return getAll();
	}

	private List<Compte> getAll() {
		return compteService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Compte getCompteById(@PathVariable Integer id) {
		return getById(id);
	}

	private Compte getById(Integer id) {
		Compte compte = compteService.getById(id);
		if (compte.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return compte;
	}
	
	@GetMapping("/user")
	@JsonView(Views.Common.class)
	public Compte getCompte(@AuthenticationPrincipal CompteSpring compteSpring) {
		return compteSpring.getCompte();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		compteService.deleteById(id);
	}
	
	@DeleteMapping("/{compte}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Compte compte) {
		compteService.delete(compte);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Views.Common.class)
	public Compte create(@RequestBody @Valid Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			System.out.println(br);
			throw new CompteInvalidException();
		}
		try {
			compte.setPassword(passwordEncoder.encode(compte.getPassword()));
			compte = compteService.save(compte);
		} catch (CompteException e) {
			throw new CompteInvalidException();
		}
		return compte;
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Compte update(@RequestBody @Valid Compte compte, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new CompteInvalidException();
		}
		compte.setId(id);
		if (!compte.getPassword().isEmpty()) {
			compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		}
		try {
			compte = compteService.save(compte);
		} catch (CompteException e) {
			throw new CompteInvalidException();
		}
		return compte;
	}
	
}
