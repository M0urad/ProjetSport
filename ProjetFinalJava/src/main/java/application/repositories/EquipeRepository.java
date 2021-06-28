package application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import application.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
	@Query("select id from Equipe where id=:id")
	Optional<Equipe> findById(@Param("id") Integer id);

}
