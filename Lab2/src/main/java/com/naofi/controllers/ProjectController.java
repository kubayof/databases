package com.naofi.controllers;

import com.naofi.model.dao.interfaces.ProjectDAO;
import com.naofi.model.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("projects")
public class ProjectController {
    private final ProjectDAO dao;

    public ProjectController(ProjectDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/id")
    @ResponseBody
    public Project getById(@RequestParam Integer id) {
        Project project = dao.getById(id);
        if (project == null) {
            throw new NullPointerException();
        }
        return project;
    }

    @GetMapping("/name")
    public String getByName(@RequestParam String name, Model model) {
        model.addAttribute("items", dao.getByName(name));

        return "list_info";
    }

    @GetMapping("/manager_id")
    @ResponseBody
    public Project getByManagerId(@RequestParam("manager_id") Integer managerId) {
        Project project = dao.getByManagerId(managerId);
        if (project == null) {
            throw new NullPointerException();
        }
        return project;
    }

    @GetMapping("/technology_id")
    @ResponseBody
    public String getByTechnologyId(@RequestParam("technology_id") Integer technologyId, Model model) {
        model.addAttribute("items", dao.getByTechnologyId(technologyId));

        return "list_info";
    }

    @PostMapping("/new")
    @ResponseBody
    public String createNew(Project project) {
        if (dao.save(project) > 0) {
            return "Inserted successfully";
        } else {
            return "Error during insert attempt";
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Project project) {
        if (dao.update(project) > 0) {
            return "Updated successfully";
        } else {
            return "Error during update attempt";
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") Integer id) {
        if (dao.deleteById(id) > 0) {
            return "Successfully deleted";
        } else {
            return "Error during delete attempt";
        }
    }
}
