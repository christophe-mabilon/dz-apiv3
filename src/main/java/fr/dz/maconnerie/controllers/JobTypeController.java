package fr.dz.maconnerie.controllers;


import fr.dz.maconnerie.entities.JobTypeEntity;
import fr.dz.maconnerie.services.JobTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/jobTypes")
public class JobTypeController {

    private JobTypeService jobTypeService;

    @GetMapping("/all")
    public List<JobTypeEntity> getAllJobTypes() {
        return jobTypeService.getAllJobTypes();
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public JobTypeEntity addJobType(@RequestBody JobTypeEntity jobType) {
        return jobTypeService.addJobType(jobType);
    }

    @DeleteMapping("/{id}")@PreAuthorize("hasRole('ADMIN')")
    public void deleteJobType(@PathVariable Long id) {
        jobTypeService.deleteJobType(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public JobTypeEntity updateJobType(@PathVariable Long id, @RequestBody JobTypeEntity updatedJobType) {
        return jobTypeService.updateJobType(id, updatedJobType);
    }
}