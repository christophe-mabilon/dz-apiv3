package fr.dz.maconnerie.services.impl;


import fr.dz.maconnerie.entities.RealisationEntity;
import fr.dz.maconnerie.repositories.RealisationRepository;
import fr.dz.maconnerie.services.RealisationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RealisationServiceImpl implements RealisationService {

    private final RealisationRepository prestationRepository;

    public RealisationServiceImpl(RealisationRepository prestationRepository) {
        this.prestationRepository = prestationRepository;
    }

    @Override
    public List<RealisationEntity> getAllRealisations() {
        return (List<RealisationEntity>) prestationRepository.findAll();
    }

    @Override
    public Optional<RealisationEntity> getRealisationById(Long id) {
        return prestationRepository.findById(id);
    }

    @Override
    public Optional<RealisationEntity> getRealisationByTitle(String title) {
        Optional<RealisationEntity> selectedRealisation = prestationRepository.findByTitle(title);
        return selectedRealisation;
    }

    @Override
    public RealisationEntity createRealisation(RealisationEntity prestationEntity) {
        prestationEntity = prestationRepository.save(prestationEntity);
        prestationEntity.setPosition(Math.toIntExact(prestationEntity.getId()));
        return prestationRepository.save(prestationEntity);
    }

    @Override
    public RealisationEntity updateRealisationPosition(Long id, Integer position) {
        RealisationEntity prestationEntity = prestationRepository.findById(id).orElseThrow(() -> new RuntimeException("RealisationEntity not found"));
        prestationEntity.setPosition(position);
        return prestationRepository.save(prestationEntity);
    }

    @Override
    public void deleteRealisation(Long id) {
        prestationRepository.deleteById(id);
    }
}
