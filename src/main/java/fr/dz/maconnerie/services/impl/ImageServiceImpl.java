package fr.dz.maconnerie.services.impl;


import fr.dz.maconnerie.entities.ImageEntity;
import fr.dz.maconnerie.repositories.ImagesRepository;
import fr.dz.maconnerie.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private final ImagesRepository imagesRepository;

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



    @Override
    public ImageEntity saveImage(ImageEntity image) {
        image = imagesRepository.save(image);
        return imagesRepository.save(image);
    }

    public ImageEntity updateImageEntity(Long id, Integer position) {
        ImageEntity imageEntity = imagesRepository.findById(id).orElseThrow(() -> new RuntimeException("ImagesEntity not found"));
        return imagesRepository.save(imageEntity);
    }

    @Override
    public void deleteImage(Long id) {
        imagesRepository.deleteById(id);
    }
}