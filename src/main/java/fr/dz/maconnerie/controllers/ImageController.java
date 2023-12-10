package fr.dz.maconnerie.controllers;

import fr.dz.maconnerie.entities.ImageEntity;
import fr.dz.maconnerie.services.ImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imagesService;

    public ImageController(ImageService imagesService) {
        this.imagesService = imagesService;
    }

    @GetMapping
    public List<ImageEntity> getAllImages() {
        return imagesService.getAllImagesEntity();
    }

    @GetMapping("/{id}")
    public ImageEntity getImageById(@PathVariable Long id) {

        return imagesService.getImageById(id);
    }

    @PostMapping
    public ImageEntity saveImage(@RequestBody ImageEntity image) {
        return imagesService.saveImage(image);
    }

    @PatchMapping("/{id}")
    public ImageEntity updateImagePosition(@PathVariable Long id, @RequestParam Integer position) {
        return imagesService.updateImageEntity(id, position);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imagesService.deleteImage(id);
    }
}
