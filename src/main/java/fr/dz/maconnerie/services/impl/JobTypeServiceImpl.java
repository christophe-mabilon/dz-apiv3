package fr.dz.maconnerie.services.impl;

import fr.dz.maconnerie.entities.ImageEntity;
import fr.dz.maconnerie.entities.JobTypeEntity;
import fr.dz.maconnerie.repositories.JobTypeRepository;
import fr.dz.maconnerie.services.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTypeServiceImpl implements JobTypeService {
    @Autowired
    private final JobTypeRepository jobTypeRepository;

    public JobTypeServiceImpl(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    public List<JobTypeEntity> getAllJobTypes() {

        return (List<JobTypeEntity>) jobTypeRepository.findAll();
    }

    public JobTypeEntity addJobType(JobTypeEntity jobType) {
        return jobTypeRepository.save(jobType);
    }

    public void deleteJobType(Long id) {
        jobTypeRepository.deleteById(id);
    }

    public JobTypeEntity updateJobType(Long id, JobTypeEntity updatedJobType) {
        // Implement update logic here
        // You may want to retrieve the existing job type by id, update its properties, and save it
        return jobTypeRepository.save(updatedJobType);
    }
@Override
    public JobTypeEntity updateImagePosition(Long id, int position){
    Optional<JobTypeEntity> selectedJobType = jobTypeRepository.findById(id);
    if (selectedJobType.isPresent()) {
        JobTypeEntity imageEntity = selectedJobType.get();
        imageEntity.setPosition(position);
        return jobTypeRepository.save(imageEntity);
    }
    return null; // or throw an exception or handle the not found case accordingly
    }
}


