package application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import application.entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Integer> {
	@Query("select id from Joueur where id=:id")
	Optional<Joueur> findById(@Param("id") Integer id);
	
	@Query("select joueur from Joueur joueur where joueur.username=:username")
	Optional<Joueur> findByUsername(@Param("username")String username);
}
