package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Rencontre;
import exceptions.RencontreException;
import repositories.RencontreRepository;

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