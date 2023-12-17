package fr.dz.maconnerie.services.impl;


import fr.dz.maconnerie.entities.PrestationEntity;
import fr.dz.maconnerie.repositories.PrestationRepository;
import fr.dz.maconnerie.services.PrestationService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public Optional<PrestationEntity> getPrestationByTitle(String title) {
        return prestationRepository.findByPrestationType(title);
    }

    @Override
    public PrestationEntity createPrestation(String prestationType, String title, String content, Integer position, String alignText, Optional<MultipartFile> file) throws IOException {
        try {
            PrestationEntity createdPrestation = PrestationEntity.builder()
                    .prestationType(prestationType)
                    .title(title)
                    .content(content)
                    .position(position)
                    .align_text(alignText)
                    .build();

            if (file.isPresent()) {
                createdPrestation.setImageData(file.get().getBytes());
            }

            return prestationRepository.save(createdPrestation);
        } catch (Exception e) {
            throw new IOException("Failed to create Prestation", e);
        }
    }

    @Override
    public PrestationEntity updatePrestation(Long id, String prestationType, String title, String content, Integer position, String alignText, Optional<MultipartFile> file) throws IOException {
        PrestationEntity prestationSelected = prestationRepository.findById(id).orElseThrow(() -> new RuntimeException("PrestationEntity not found"));
        try {
            prestationSelected.setPrestationType(prestationType);
            prestationSelected.setTitle(title);
            prestationSelected.setContent(content);
            prestationSelected.setPosition(position);
            prestationSelected.setAlign_text(alignText);
            if (file.isPresent()) {
                prestationSelected.setImageData(file.get().getBytes());
            }
            return prestationRepository.save(prestationSelected);
        } catch (Exception e) {
            throw new IOException("Failed to create Prestation", e);
        }

    }

    @Override
    public void deletePrestation(Long id) {
        prestationRepository.deleteById(id);
    }
}