package fr.dz.maconnerie.repositories;

import fr.dz.maconnerie.entities.ImageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImagesRepository extends CrudRepository<ImageEntity, Long> {
    Optional<ImageEntity> findById(Long id);
}