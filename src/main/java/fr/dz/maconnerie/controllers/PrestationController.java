package fr.dz.maconnerie.controllers;

import fr.dz.maconnerie.entities.PrestationEntity;
import fr.dz.maconnerie.services.PrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/prestations")
public class PrestationController {

    @Autowired
    private final PrestationService prestationService;

    public PrestationController(PrestationService prestationService) {
        this.prestationService = prestationService;
    }


    @GetMapping("/all")
    public List<PrestationEntity> getAllPrestations() {
        return prestationService.getAllPrestations();
    }

    @PostMapping("/add")
    public PrestationEntity createPrestation(@RequestBody PrestationEntity prestationEntity) {
        return prestationService.createPrestation(prestationEntity);
    }

    @PatchMapping("/{id}")
    public PrestationEntity updatePrestationPosition(@PathVariable Long id, @RequestParam Integer position) {
        return prestationService.updatePrestationPosition(id, position);
    }

    @DeleteMapping("/{id}")
    public void deletePrestation(@PathVariable Long id) {

        prestationService.deletePrestation(id);
    }
}