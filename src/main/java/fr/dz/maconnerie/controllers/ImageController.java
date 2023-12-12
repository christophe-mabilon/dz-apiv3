package fr.dz.maconnerie.controllers;

import fr.dz.maconnerie.entities.ImageEntity;
import fr.dz.maconnerie.services.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imagesService;

    public ImageController(ImageService imagesService) {
        this.imagesService = imagesService;
    }

    @GetMapping("all")
    public List<ImageEntity> getAllImages() {
        return imagesService.getAllImagesEntity();
    }

    @GetMapping("/{id}")
    public ImageEntity getImageById(@PathVariable Long id) {
        return imagesService.getImageById(id);
    }

    @PostMapping("/add")
    public ImageEntity saveImage(@ModelAttribute ImageEntity image, @RequestParam("file") MultipartFile file) throws IOException {
        return imagesService.saveImage(image, file);
    }

    @PutMapping("/edit")
    public ImageEntity updateImage(@ModelAttribute ImageEntity image, @RequestParam("file") MultipartFile file) throws IOException {
        return imagesService.updateImageEntity(image, file);
    }

    @PutMapping("position/{id}")
    public ResponseEntity<ImageEntity> updateImage(@PathVariable Long id, @RequestBody int position) {
        ImageEntity updatedImage = imagesService.updateImagePosition(id, position);

        if (updatedImage != null) {
            return new ResponseEntity<>(updatedImage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imagesService.deleteImage(id);
    }
}