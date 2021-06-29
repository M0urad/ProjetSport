package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entities.Inscription;
import application.exceptions.InscriptionException;
import application.repositories.InscriptionRepository;

@Service
public class InscriptionService {
	
	@Autowired
	InscriptionRepository inscriptionRepository;
	
	
	public Inscription save(Inscription inscription) throws InscriptionException {
//		if (inscription.getJoueur() == null) {
//			throw new InscriptionException("Joueur obligatoire");
//		}
		if (inscription.getPlacesReservees() == 0) {
			throw new InscriptionException("Pas de nombres de places réservées pour cette inscription");
		}
		return inscriptionRepository.save(inscription);
	}
	
	public void delete(Inscription inscription) {
		if (inscription != null) {
			inscriptionRepository.delete(inscription);
		}
	}
	
	public void deleteById(Integer id) {
		if (id != null) {
			inscriptionRepository.deleteById(id);
		}
	}
	
	public List<Inscription> getAll() {
		return inscriptionRepository.findAll();
	}
	public Inscription getById(Integer id) {
		if (id != null) {
			Optional<Inscription> opt = inscriptionRepository.findById(id);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		return new Inscription();

	}

}
