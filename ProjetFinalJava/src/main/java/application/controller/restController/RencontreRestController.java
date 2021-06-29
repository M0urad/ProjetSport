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

import application.entities.Rencontre;
import application.exceptions.RencontreException;
import application.exceptions.rest.RencontreInvalidException;
import application.services.RencontreService;
import application.views.Views;

@RestController
@RequestMapping("/api/rencontre")
@CrossOrigin(origins = "*")
public class RencontreRestController {

	@Autowired
	private RencontreService rencontreService;
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Rencontre> getAllRencontre(){
		return getAll();
	}
	
	
	private List<Rencontre> getAll(){
		return rencontreService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Rencontre getRencontreById(@PathVariable Integer id) {
		return getById(id);
	}
	
	
	private Rencontre getById(Integer id) {
		Rencontre rencontre = rencontreService.getById(id);
		if (rencontre.getId()==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return rencontre;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		rencontreService.delete(id);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Views.Common.class)
	public Rencontre create(@RequestBody @Valid Rencontre rencontre, BindingResult br) {
		if (br.hasErrors()) {
			throw new RencontreInvalidException();
		}
		try {
//			rencontre.getUtilisateur().setPassword(passwordEncoder.encode(rencontre.getUtilisateur().getPassword()));
			rencontre = rencontreService.save(rencontre);
		} catch (RencontreException e) {
			throw new RencontreInvalidException();
		}
		return rencontre;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Rencontre update(@RequestBody @Valid Rencontre client, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new RencontreInvalidException();
		}
//		client.setId(id);
//		if (!client.getUtilisateur().getPassword().isEmpty()) {
//			client.getUtilisateur().setPassword(passwordEncoder.encode(client.getUtilisateur().getPassword()));
//		}
		try {
			client = rencontreService.save(client);
		} catch (RencontreException e) {
			throw new RencontreInvalidException();
		}
		return client;
	}
	
}
