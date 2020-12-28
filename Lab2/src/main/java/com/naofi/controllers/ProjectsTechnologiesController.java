package com.naofi.controllers;

import com.naofi.model.dao.interfaces.ProjectTechnologyDAO;
import com.naofi.model.entity.ProjectTechnology;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects_technologies")
public class ProjectsTechnologiesController {
    private final ProjectTechnologyDAO dao;

    public ProjectsTechnologiesController(ProjectTechnologyDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/project_id")
    public String getByProjectId(@RequestParam("project_id") Integer projectId, Model model) {
        model.addAttribute("items", dao.getByProjectId(projectId));

        return "list_info";
    }

    @GetMapping("/technology_id")
    public String getByTechnologyId(@RequestParam("technology_id") Integer technologyId, Model model) {
        model.addAttribute("items", dao.getByTechnologyId(technologyId));

        return "list_info";
    }

    @GetMapping("/id")
    @ResponseBody
    public ProjectTechnology getById(@RequestParam("project_id") Integer projectId,
                                     @RequestParam("technology_id") Integer technologyId) {
        ProjectTechnology projectTechnology = dao.getById(projectId, technologyId);
        if (projectTechnology == null) {
            throw new NullPointerException();
        }
        return projectTechnology;
    }

    @PostMapping("/new")
    @ResponseBody
    public String createNew(ProjectTechnology entity) {
        if (dao.save(entity) > 0) {
            return "Successfully inserted";
        } else {
            return "Error during insert attempt";
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(ProjectTechnology entity) {
        if (dao.delete(entity) > 0) {
            return "Successfully deleted";
        } else {
            return "Error during delete attempt";
        }
    }

}
