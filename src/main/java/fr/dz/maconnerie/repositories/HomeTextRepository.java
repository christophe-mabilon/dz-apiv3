package fr.dz.maconnerie.repositories;

import fr.dz.maconnerie.entities.HomeTextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeTextRepository extends JpaRepository<HomeTextEntity, Long> {
}