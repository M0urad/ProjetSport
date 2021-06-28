package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Joueur;
import exceptions.JoueurException;
import repositories.JoueurRepository;

@Service
public class JoueurService {
	
	@Autowired
	JoueurRepository joueurRepository;
	
	
	public Joueur save(Joueur joueur) throws JoueurException {
		if (joueur.getNom() == null || joueur.getNom().isEmpty()) {
			throw new JoueurException("Nom obligatoire");
		}
		if (joueur.getCompte() == null) {
			throw new JoueurException("Pas de compte pour ce joueur");
		}
		return joueurRepository.save(joueur);
	}
	
	public void delete(Joueur joueur) {
		if (joueur != null) {
			joueurRepository.delete(joueur);
		}
	}
	
	public List<Joueur> getAll() {
		return joueurRepository.findAll();
	}
	public Joueur getById(Integer id) {
		if (id != null) {
			Optional<Joueur> opt = joueurRepository.findById(id);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		return new Joueur();

	}

}