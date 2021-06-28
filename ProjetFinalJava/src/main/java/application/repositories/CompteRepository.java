package application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import application.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
	@Query("select id from Compte where id=:id")
	Optional<Compte> findById(@Param("id") Integer id);
}
