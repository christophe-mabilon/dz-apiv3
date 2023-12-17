package fr.dz.maconnerie.services;

import fr.dz.maconnerie.entities.PrestationEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PrestationService {
    List<PrestationEntity> getAllPrestations();


    Optional<PrestationEntity> getPrestationByTitle(String title);

    PrestationEntity createPrestation(String prestationType, String title, String content, Integer position, String alignText, Optional<MultipartFile> file) throws IOException;

    PrestationEntity updatePrestation(Long id, String prestationTypee, String title, String content, Integer position, String alignText, Optional<MultipartFile> file) throws IOException;


    void deletePrestation(Long id);
}