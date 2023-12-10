package fr.dz.maconnerie.services.impl;

import fr.dz.maconnerie.entities.HomeTextEntity;
import fr.dz.maconnerie.repositories.HomeTextRepository;
import fr.dz.maconnerie.services.HomeTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeTextServiceImpl implements HomeTextService {
    @Autowired
    private HomeTextRepository homeTextRepository;

    @Override
    public List<HomeTextEntity> getAllHomeTexts() {
        return homeTextRepository.findAll();
    }

    @Override
    public HomeTextEntity createHomeText(HomeTextEntity homeText) {
        homeText = homeTextRepository.save(homeText);
        homeText.setPosition(Math.toIntExact(homeText.getId()));
        return homeTextRepository.save(homeText);
    }

    @Override
    public HomeTextEntity updateHomeTextPosition(Long id, Integer position) {
        HomeTextEntity homeText = homeTextRepository.findById(id).orElseThrow(() -> new RuntimeException("HomeText not found"));
        homeText.setPosition(position);
        return homeTextRepository.save(homeText);
    }

    @Override
    public void deleteHomeText(Long id) {
        homeTextRepository.deleteById(id);
    }
}