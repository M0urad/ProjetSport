package application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import application.entities.Rencontre;

public interface RencontreRepository extends JpaRepository<Rencontre, Integer> {
	@Query("select id from Rencontre where id=:id")
	Optional<Rencontre> findById(@Param("id") Integer id);
}
