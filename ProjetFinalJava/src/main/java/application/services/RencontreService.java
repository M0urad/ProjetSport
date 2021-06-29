package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entities.Joueur;
import application.entities.Rencontre;
import application.exceptions.RencontreException;
import application.repositories.RencontreRepository;

@Service
public class RencontreService {
	
	@Autowired
	RencontreRepository rencontreRepository;
	
	
	public Rencontre save(Rencontre rencontre) throws RencontreException {
		if (rencontre.getName() == null || rencontre.getName().isEmpty()) {
			throw new RencontreException("Nom obligatoire");
		}
		if (rencontre.getDate() == null) {
			throw new RencontreException("Pas de date pour ce rencontre");
		}
		return rencontreRepository.save(rencontre);
	}
	
	public void delete(Rencontre rencontre) {
		if (rencontre != null) {
			rencontreRepository.delete(rencontre);
		}
	}
	
	public void delete(Integer id) {
		if (id != null) {
			Optional<Rencontre> opt = rencontreRepository.findById(id);
			if (opt.isPresent()) {
				delete(opt.get());
			}
		}
	}
	
	public List<Rencontre> getAll() {
		return rencontreRepository.findAll();
	}
	public Rencontre getById(Integer id) {
		if (id != null) {
			Optional<Rencontre> opt = rencontreRepository.findById(id);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		return new Rencontre();

	}

}