package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entities.Equipe;
import application.exceptions.EquipeException;
import application.repositories.EquipeRepository;

@Service
public class EquipeService {
	
	@Autowired
	EquipeRepository equipeRepository;
	
	
	public Equipe save(Equipe equipe) throws EquipeException {
		if (equipe.getName() == null || equipe.getName().isEmpty()) {
			throw new EquipeException("Nom obligatoire");
		}
		if (equipe.getKey() == null) {
			throw new EquipeException("Pas de Key pour cette equipe");
		}
		return equipeRepository.save(equipe);
	}
	
	public void delete(Equipe equipe) {
		if (equipe != null) {
			equipeRepository.delete(equipe);
		}
	}
	
	public List<Equipe> getAll() {
		return equipeRepository.findAll();
	}
	public Equipe getById(Integer id) {
		if (id != null) {
			Optional<Equipe> opt = equipeRepository.findById(id);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		return new Equipe();

	}

}
