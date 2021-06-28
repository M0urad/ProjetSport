package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entities.Compte;
import application.entities.Role;
import application.exceptions.CompteException;
import application.repositories.CompteRepository;

@Service
public class CompteService {
	
	@Autowired
	CompteRepository compteRepository;
	
	
	public Compte save(Compte compte) throws CompteException {
		if (compte.getUsername() == null || compte.getUsername().isEmpty()) {
			throw new CompteException("Nom obligatoire");
		}
		if (compte.getEmail() == null) {
			throw new CompteException("Pas de d'email pour ce compte");
		}
		compte.setRole(Role.ROLE_USER);
		return compteRepository.save(compte);
	}
	
	public void delete(Compte compte) {
		if (compte != null) {
			compteRepository.delete(compte);
		}
	}
	
	public List<Compte> getAll() {
		return compteRepository.findAll();
	}
	public Compte getById(Integer id) {
		if (id != null) {
			Optional<Compte> opt = compteRepository.findById(id);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		return new Compte();

	}

}
