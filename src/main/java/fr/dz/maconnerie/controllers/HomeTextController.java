package fr.dz.maconnerie.controllers;

import fr.dz.maconnerie.entities.HomeTextEntity;
import fr.dz.maconnerie.services.HomeTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/homeTexts")
public class HomeTextController {
    @Autowired
    private HomeTextService homeTextService;

    @GetMapping("/all")
    public List<HomeTextEntity> getAllHomeTexts() {
        return homeTextService.getAllHomeTexts();
    }

    @PostMapping("/add")
    public HomeTextEntity createHomeText(
            @RequestPart("imageData") Optional<MultipartFile> file,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("position") Integer position,
            @RequestParam("align_text") String alignText) throws IOException {

        return homeTextService.createHomeText(title,content,position,alignText,file);
    }

    @PutMapping("/{id}")
    public HomeTextEntity updateHomeText(@PathVariable Long id,
                                         @RequestPart("imageData") Optional<MultipartFile> file,
                                         @RequestParam("title") String title,
                                         @RequestParam("content") String content,
                                         @RequestParam("position") Integer position,
                                         @RequestParam("align_text") String alignText) throws IOException {
        return homeTextService.updateHomeText(
                id,
                title,
                content,
                position,
                alignText,
                file        );
    }

    @PutMapping("position/{id}")
    public ResponseEntity<HomeTextEntity> updateImage(@PathVariable Long id, @RequestBody int position) {
        HomeTextEntity updatedPosition = homeTextService.updateImagePosition(id, position);

        if (updatedPosition != null) {
            return new ResponseEntity<>(updatedPosition, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteHomeText(@PathVariable Long id) {
        homeTextService.deleteHomeText(id);
    }
}
