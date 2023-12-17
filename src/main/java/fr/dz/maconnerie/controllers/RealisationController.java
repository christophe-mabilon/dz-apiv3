package fr.dz.maconnerie.controllers;

import fr.dz.maconnerie.entities.RealisationEntity;
import fr.dz.maconnerie.services.RealisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/realisations")
public class RealisationController {
    @Autowired
    private final RealisationService realisationService;

    public RealisationController(RealisationService realisationService) {
        this.realisationService = realisationService;
    }


    @GetMapping("/all")
    public List<RealisationEntity> getAllRealisations() {
        return realisationService.getAllRealisations();
    }

    @PostMapping("/add")
    public RealisationEntity createRealisation(@RequestBody RealisationEntity realisationEntity) {
        return realisationService.createRealisation(realisationEntity);
    }

    @PatchMapping("/{id}")
    public RealisationEntity updateRealisationPosition(@PathVariable Long id, @RequestParam Integer position) {
        return realisationService.updateRealisationPosition(id, position);
    }

    @DeleteMapping("/{id}")
    public void deleteRealisation(@PathVariable Long id) {
        realisationService.deleteRealisation(id);
    }
}
