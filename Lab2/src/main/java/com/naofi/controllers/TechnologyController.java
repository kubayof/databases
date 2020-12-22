package com.naofi.controllers;

import com.naofi.model.dao.interfaces.TechnologyDAO;
import com.naofi.model.entity.Technology;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {
    private final TechnologyDAO dao;

    public TechnologyController(TechnologyDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/id")
    public Technology getById(@RequestParam Integer id) {
        return dao.getById(id);
    }

    @GetMapping("/name")
    public List<Technology> getByName(@RequestParam String name) {
        return dao.getByName(name);
    }

    @GetMapping("/programmer_id")
    public List<Technology> getByProgrammerId(@RequestParam("programmer_id") Integer programmerId) {
        return dao.getByProgrammerId(programmerId);
    }

    @GetMapping("/project_id")
    public List<Technology> getByProjectId(@RequestParam("project_id") Integer projectId) {
        return dao.getByProjectId(projectId);
    }

    @PostMapping("/new")
    public String createNew(Technology technology) {
        if (dao.save(technology) > 0) {
            return "Inserted successfully";
        } else {
            return "Error during insert attempt";
        }
    }

    @PostMapping("/update")
    public String update(Technology technology) {
        if (dao.update(technology) > 0) {
            return "Updated successfully";
        } else {
            return "Error during update attempt";
        }
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        if (dao.deleteById(id) > 0) {
            return "Successfully deleted";
        } else {
            return "Error during delete attempt";
        }
    }
}
