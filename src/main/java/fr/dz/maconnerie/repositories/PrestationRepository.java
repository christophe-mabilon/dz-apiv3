package fr.dz.maconnerie.repositories;

import fr.dz.maconnerie.entities.PrestationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrestationRepository extends CrudRepository<PrestationEntity,Long> {
    Optional<PrestationEntity> findByTitle(String title);
}
