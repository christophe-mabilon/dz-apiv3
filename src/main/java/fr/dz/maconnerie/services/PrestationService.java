package fr.dz.maconnerie.services;

import fr.dz.maconnerie.entities.PrestationEntity;

import java.util.List;
import java.util.Optional;

public interface PrestationService {
    List<PrestationEntity> getAllPrestations();

    Optional<PrestationEntity> getPrestationById(Long id);

    Optional<PrestationEntity> getPrestationByTitle(String title);

    PrestationEntity createPrestation(PrestationEntity prestationEntity);

    PrestationEntity updatePrestationPosition(Long id, Integer position);

    void deletePrestation(Long id);
}