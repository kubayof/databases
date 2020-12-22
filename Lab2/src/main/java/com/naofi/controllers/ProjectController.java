package com.naofi.controllers;

import com.naofi.model.dao.interfaces.ProjectDAO;
import com.naofi.model.entity.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("projects")
public class ProjectController {
    private final ProjectDAO dao;

    public ProjectController(ProjectDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/id")
    public Project getById(@RequestParam Integer id) {
        return dao.getById(id);
    }

    @GetMapping("/name")
    public List<Project> getByName(@RequestParam String name) {
        return dao.getByName(name);
    }

    @GetMapping("/manager_id")
    public Project getByManagerId(@RequestParam("manager_id") Integer managerId) {
        return dao.getByManagerId(managerId);
    }

    @GetMapping("/technology_id")
    public List<Project> getByTechnologyId(@RequestParam("technology_id") Integer technologyId) {
        return dao.getByTechnologyId(technologyId);
    }

    @PostMapping("/new")
    public String createNew(Project project) {
        if (dao.save(project) > 0) {
            return "Inserted successfully";
        } else {
            return "Error during insert attempt";
        }
    }

    @PostMapping("/update")
    public String update(Project project) {
        if (dao.update(project) > 0) {
            return "Updated successfully";
        } else {
            return "Error during update attempt";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        if (dao.deleteById(id) > 0) {
            return "Successfully deleted";
        } else {
            return "Error during delete attempt";
        }
    }
}
