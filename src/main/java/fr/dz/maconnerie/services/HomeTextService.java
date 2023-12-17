package fr.dz.maconnerie.services;

import fr.dz.maconnerie.entities.HomeTextEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface HomeTextService {
    List<HomeTextEntity> getAllHomeTexts();

    HomeTextEntity createHomeText(String title, String content, Integer position, String alignText, Optional<MultipartFile> file) throws IOException;


    HomeTextEntity updateHomeText(Long id,String title, String content, Integer position, String alignText, Optional<MultipartFile> file) throws IOException;

    void deleteHomeText(Long id);

    HomeTextEntity updateImagePosition(Long id, int position);
}
