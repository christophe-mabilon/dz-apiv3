package fr.dz.maconnerie.controllers;


import fr.dz.maconnerie.entities.JobTypeEntity;
import fr.dz.maconnerie.services.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/jobTypes")
public class JobTypeController {

    @Autowired
    private JobTypeService jobTypeService;

    @GetMapping("/all")
    public List<JobTypeEntity> getAllJobTypes() {
        return jobTypeService.getAllJobTypes();
    }

    @PostMapping("/add")
    public JobTypeEntity addJobType(@RequestBody JobTypeEntity jobType) {
        return jobTypeService.addJobType(jobType);
    }

    @DeleteMapping("/{id}")
    public void deleteJobType(@PathVariable Long id) {
        jobTypeService.deleteJobType(id);
    }

    @PutMapping("/{id}")
    public JobTypeEntity updateJobType(@PathVariable Long id, @RequestBody JobTypeEntity updatedJobType) {
        return jobTypeService.updateJobType(id, updatedJobType);
    }
}