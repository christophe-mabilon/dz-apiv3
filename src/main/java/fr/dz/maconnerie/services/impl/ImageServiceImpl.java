package fr.dz.maconnerie.services.impl;

import fr.dz.maconnerie.entities.ImageEntity;
import fr.dz.maconnerie.repositories.ImagesRepository;
import fr.dz.maconnerie.services.ImageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImagesRepository imagesRepository;

    @Autowired
    public ImageServiceImpl(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    @Override
    public List<ImageEntity> getAllImagesEntity() {
        return (List<ImageEntity>) imagesRepository.findAll();
    }

    @Override
    public ImageEntity getImageById(Long id) {
        return imagesRepository.findById(id).orElse(null);
    }

    @Transactional
    public ImageEntity saveImage(ImageEntity originalImage, MultipartFile file) throws IOException {
        try {
            // Convert MultipartFile to byte array
            byte[] fileBytes = file.getBytes();

            // Create a new ImageEntity with the image data
            ImageEntity imageEntityToSave = ImageEntity.builder()
                    .id(null)
                    .name(originalImage.getName())
                    .text(originalImage.getText())
                    .position(originalImage.getPosition())
                    .imageData(fileBytes)
                    .build();

            // Save the ImageEntity to the repository and return the saved entity
            return imagesRepository.save(imageEntityToSave);
        } catch (IOException e) {
            throw new IOException("Failed to save image", e);
        }
    }

    @Override
    public ImageEntity updateImageEntity(ImageEntity originalImage, MultipartFile file) throws IOException {
        try {
            // Convert MultipartFile to byte array
            byte[] fileBytes = file.getBytes();

            // Create a new ImageEntity with the image data
            ImageEntity imageEntityToSave = originalImage.builder()
                    .id(originalImage.getId())
                    .name(originalImage.getName())
                    .text(originalImage.getText())
                    .position(originalImage.getPosition())
                    .imageData(fileBytes)
                    .build();

            // Save the ImageEntity to the repository and return the saved entity
            return imagesRepository.save(imageEntityToSave);
        } catch (IOException e) {
            throw new IOException("Failed to edit image", e);
        }
    }
    @Override
    public ImageEntity updateImagePosition(Long id, int position) {
        Optional<ImageEntity> selectedImage = imagesRepository.findById(id);
        if (selectedImage.isPresent()) {
            ImageEntity imageEntity = selectedImage.get();
            imageEntity.setPosition(position);
            return imagesRepository.save(imageEntity);
        }
        return null; // or throw an exception or handle the not found case accordingly
    }

    @Override
    public void deleteImage(Long id) {
        imagesRepository.deleteById(id);
    }
}