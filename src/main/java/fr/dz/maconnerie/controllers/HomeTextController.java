package fr.dz.maconnerie.controllers;

import fr.dz.maconnerie.entities.HomeTextEntity;
import fr.dz.maconnerie.services.HomeTextService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/hometexts")
public class HomeTextController {

    private final HomeTextService homeTextService;

    public HomeTextController(HomeTextService homeTextService) {
        this.homeTextService = homeTextService;
    }

    @GetMapping
    public List<HomeTextEntity> getAllHomeTexts() {
        return homeTextService.getAllHomeTexts();
    }

    @PostMapping
    public HomeTextEntity createHomeText(@RequestBody HomeTextEntity homeText) {
        return homeTextService.createHomeText(homeText);
    }

    @PatchMapping("/{id}")
    public HomeTextEntity updateHomeTextPosition(@PathVariable Long id, @RequestParam Integer position) {
        return homeTextService.updateHomeTextPosition(id, position);
    }

    @DeleteMapping("/{id}")
    public void deleteHomeText(@PathVariable Long id) {
        homeTextService.deleteHomeText(id);
    }
}
