package fr.dz.maconnerie.services.impl;


import fr.dz.maconnerie.entities.PrestationEntity;
import fr.dz.maconnerie.repositories.PrestationRepository;
import fr.dz.maconnerie.services.PrestationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestationServiceImpl implements PrestationService {

    private final PrestationRepository prestationRepository;

    public PrestationServiceImpl(PrestationRepository prestationRepository) {
        this.prestationRepository = prestationRepository;
    }

    @Override
    public List<PrestationEntity> getAllPrestations() {
        return (List<PrestationEntity>) prestationRepository.findAll();
    }

    @Override
    public Optional<PrestationEntity> getPrestationById(Long id) {
        return prestationRepository.findById(id);
    }

    @Override
    public Optional<PrestationEntity> getPrestationByTitle(String title) {
        Optional<PrestationEntity> selectedPrestation = prestationRepository.findByTitle(title);
        return selectedPrestation;
    }

    @Override
    public PrestationEntity createPrestation(PrestationEntity prestationEntity) {
        prestationEntity = prestationRepository.save(prestationEntity);
        prestationEntity.setPosition(Math.toIntExact(prestationEntity.getId()));
        return prestationRepository.save(prestationEntity);
    }

    @Override
    public PrestationEntity updatePrestationPosition(Long id, Integer position) {
        PrestationEntity prestationEntity = prestationRepository.findById(id).orElseThrow(() -> new RuntimeException("PrestationEntity not found"));
        prestationEntity.setPosition(position);
        return prestationRepository.save(prestationEntity);
    }

    @Override
    public void deletePrestation(Long id) {
        prestationRepository.deleteById(id);
    }
}