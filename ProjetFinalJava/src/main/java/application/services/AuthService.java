package application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.config.CompteSpring;
import application.entities.Compte;
import application.repositories.CompteRepository;



@Service
public class AuthService implements UserDetailsService {

	@Autowired
	private CompteRepository compteRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Compte> opt = compteRepo.findByUsername(username);
		if (opt.isPresent()) {
			return new CompteSpring(opt.get());
		}
		throw new UsernameNotFoundException("utilisateur introuvable");
	}

}
