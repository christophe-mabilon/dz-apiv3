package fr.dz.maconnerie.repositories;

import fr.dz.maconnerie.entities.JobTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface JobTypeRepository extends CrudRepository<JobTypeEntity, Long> {
}
