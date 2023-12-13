package fr.dz.maconnerie.services;

import fr.dz.maconnerie.entities.JobTypeEntity;

import java.util.List;

public interface JobTypeService {
    public List<JobTypeEntity> getAllJobTypes();
    public JobTypeEntity addJobType(JobTypeEntity jobType);
    public void deleteJobType(Long id);
    public JobTypeEntity updateJobType(Long id, JobTypeEntity updatedJobType);

    public JobTypeEntity updateImagePosition(Long id, int position);
}
