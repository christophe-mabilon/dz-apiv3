package fr.dz.maconnerie.controllers;

import fr.dz.maconnerie.entities.PrestationEntity;
import fr.dz.maconnerie.services.PrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/prestations")
public class PrestationController {
    @Autowired
    private PrestationService prestationService;

    @GetMapping("/all")
    public List<PrestationEntity> getAllPrestations() {
        return prestationService.getAllPrestations();
    }

    @GetMapping("/{title}")
    public Optional<PrestationEntity> getPrestationByTitle(@PathVariable String title) {
        return prestationService.getPrestationByTitle(title);
    }

    @PostMapping("/add")
    public PrestationEntity createPrestation(
            @RequestParam("prestationType") String prestation_type,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("position") Integer position,
            @RequestParam("align_text") String alignText,
            @RequestPart("imageData") Optional<MultipartFile> file) throws IOException {

        return prestationService.createPrestation(prestation_type, title, content, position, alignText, file);
    }

    @PutMapping("/{id}")
    public PrestationEntity updatePrestation(@PathVariable Long id,
                                             @RequestParam("prestationType") String prestation_type,
                                             @RequestParam("title") String title,
                                             @RequestParam("content") String content,
                                             @RequestParam("position") Integer position,
                                             @RequestParam("align_text") String alignText,
                                             @RequestPart("imageData") Optional<MultipartFile> file) throws IOException {
        return prestationService.updatePrestation(
                id,
                prestation_type,
                title,
                content,
                position,
                alignText,
                file);
    }


    @DeleteMapping("/{id}")
    public void deletePrestation(@PathVariable Long id) {
        prestationService.deletePrestation(id);
    }

}