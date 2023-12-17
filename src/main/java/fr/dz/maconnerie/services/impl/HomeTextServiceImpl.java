package fr.dz.maconnerie.services.impl;

import fr.dz.maconnerie.entities.HomeTextEntity;
import fr.dz.maconnerie.entities.JobTypeEntity;
import fr.dz.maconnerie.repositories.HomeTextRepository;
import fr.dz.maconnerie.services.HomeTextService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class HomeTextServiceImpl implements HomeTextService {
    @Autowired
    private HomeTextRepository homeTextRepository;

    @Override
    public List<HomeTextEntity> getAllHomeTexts() {
        return homeTextRepository.findAll();
    }

    @Override
    public HomeTextEntity createHomeText(String title, String content, Integer position, String alignText, Optional<MultipartFile> file) throws IOException {
        try {
            HomeTextEntity homeText = HomeTextEntity.builder()
                    .title(title)
                    .content(content)
                    .position(position)
                    .align_text(alignText)
                    .build();

            if(file.isPresent()){
                homeText.setImageData(file.get().getBytes());
            }


            return homeTextRepository.save(homeText);
        } catch (Exception e) {
            throw new IOException("Failed to edit image", e);

        }
    }

    @Override
    public HomeTextEntity updateHomeText(Long id, String title, String content, Integer position, String alignText, Optional<MultipartFile> file) throws IOException {
        HomeTextEntity homeTextEntity = homeTextRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("HomeTextEntity not found with id: " + id));

        homeTextEntity.setTitle(title);
        homeTextEntity.setContent(content);
        homeTextEntity.setPosition(position);
        homeTextEntity.setAlign_text(alignText);

        if (file != null && !file.isEmpty()) {
            try {
                byte[] imageDataBytes = file.get().getBytes();
                homeTextEntity.setImageData(imageDataBytes);
            } catch (IOException e) {
                throw new IOException("Failed to edit image", e);
            }
        }else{
            homeTextEntity.setImageData(null);
        }

        return homeTextRepository.save(homeTextEntity);
    }


    @Override
    public HomeTextEntity updateImagePosition(Long id, int position) {
        Optional<HomeTextEntity> selectedHomeText = homeTextRepository.findById(id);
        if (selectedHomeText.isPresent()) {
            HomeTextEntity imageEntity = selectedHomeText.get();
            imageEntity.setPosition(position);
            return homeTextRepository.save(imageEntity);
        }
        return null; // or throw an exception or handle the not found case accordingly
    }


    @Override
    public void deleteHomeText(Long id) {
        homeTextRepository.deleteById(id);
    }
}