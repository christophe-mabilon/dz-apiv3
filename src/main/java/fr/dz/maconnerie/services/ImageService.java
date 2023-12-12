package fr.dz.maconnerie.services;

import fr.dz.maconnerie.entities.ImageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


public interface ImageService {

  public List<ImageEntity> getAllImagesEntity() ;


  public ImageEntity getImageById(Long id);


  public ImageEntity saveImage(ImageEntity originalImage, MultipartFile file) throws IOException;


  public ImageEntity updateImageEntity(ImageEntity originalImage, MultipartFile file) throws IOException;


  public void deleteImage(Long id);

 public ImageEntity updateImagePosition(Long id, int position);
 }