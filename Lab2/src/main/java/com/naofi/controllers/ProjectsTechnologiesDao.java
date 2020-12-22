package com.naofi.controllers;

import com.naofi.model.dao.interfaces.ProjectTechnologyDAO;
import com.naofi.model.entity.ProjectTechnology;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects_technologies")
public class ProjectsTechnologiesDao {
    private final ProjectTechnologyDAO dao;

    public ProjectsTechnologiesDao(ProjectTechnologyDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/project_id_")
    public List<ProjectTechnology> getByProjectId(@RequestParam("project_id") Integer projectId) {
        return dao.getByProjectId(projectId);
    }

    @GetMapping("/technologyId")
    public List<ProjectTechnology> getByTechnologyId(@RequestParam("technology_id") Integer technologyId) {
        return dao.getByTechnologyId(technologyId);
    }

    @GetMapping("/id")
    public ProjectTechnology getById(@RequestParam("project_id") Integer projectId,
                                     @RequestParam("technology_id") Integer technologyId) {
        return dao.getById(projectId, technologyId);
    }

    @PostMapping("/new")
    public String createNew(ProjectTechnology entity) {
        if (dao.save(entity) > 0) {
            return "Successfully inserted";
        } else {
            return "Error during insert attempt";
        }
    }

    @DeleteMapping("/delete")
    public String delete(ProjectTechnology entity) {
        if (dao.delete(entity) > 0) {
            return "Successfully deleted";
        } else {
            return "Error during delete attempt";
        }
    }

}
