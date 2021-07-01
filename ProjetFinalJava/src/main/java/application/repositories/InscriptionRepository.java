package application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import application.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
	@Query("select id from Inscription where id=:id")
	Optional<Inscription> findById(@Param("id") Integer id);

	@Query("select inscription from Inscription inscription where inscription.key.rencontre.id=:idRencontre")
	List<Inscription> findByRencontre(Integer idRencontre);
}
