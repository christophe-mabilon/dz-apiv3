package fr.dz.maconnerie.services;

import fr.dz.maconnerie.entities.HomeTextEntity;

import java.util.List;

public interface HomeTextService {
    List<HomeTextEntity> getAllHomeTexts();

    HomeTextEntity createHomeText(HomeTextEntity homeText);

    HomeTextEntity updateHomeTextPosition(Long id, Integer position);

    void deleteHomeText(Long id);
}
