package fr.dz.maconnerie.services;

import fr.dz.maconnerie.entities.RealisationEntity;

import java.util.List;
import java.util.Optional;


public interface RealisationService {
    List<RealisationEntity> getAllRealisations();

    Optional<RealisationEntity> getRealisationById(Long id);

    Optional<RealisationEntity> getRealisationByTitle(String title);

    RealisationEntity createRealisation(RealisationEntity prestationEntity);

    RealisationEntity updateRealisationPosition(Long id, Integer position);

    void deleteRealisation(Long id);
}
