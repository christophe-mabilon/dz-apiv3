package fr.dz.maconnerie.repositories;

import fr.dz.maconnerie.entities.RealisationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RealisationRepository extends CrudRepository<RealisationEntity,Long> {
    Optional<RealisationEntity> findByTitle(String title);
}
