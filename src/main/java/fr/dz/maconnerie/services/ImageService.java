package fr.dz.maconnerie.services;

import fr.dz.maconnerie.entities.ImageEntity;

import java.util.List;


 public interface ImageService {

    List<ImageEntity> getAllImagesEntity();

     ImageEntity getImageById(Long id);

     ImageEntity saveImage(ImageEntity image);

     ImageEntity updateImageEntity(Long id, Integer position);

     void deleteImage(Long id);
 }