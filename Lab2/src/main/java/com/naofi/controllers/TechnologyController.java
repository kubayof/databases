package com.naofi.controllers;

import com.naofi.model.dao.interfaces.TechnologyDAO;
import com.naofi.model.entity.Technology;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/technologies")
public class TechnologyController {
    private final TechnologyDAO dao;

    public TechnologyController(TechnologyDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/id")
    @ResponseBody
    public Technology getById(@RequestParam Integer id) {
        Technology technology = dao.getById(id);
        if (technology == null) {
            throw new NullPointerException();
        }
        return technology;
    }

    @GetMapping("/name")
    public String getByName(@RequestParam String name, Model model) {
        model.addAttribute("items", dao.getByName(name));

        return "list_info";
    }

    @GetMapping("/programmer_id")
    public String getByProgrammerId(@RequestParam("programmer_id") Integer programmerId, Model model) {
        model.addAttribute("items", dao.getByProgrammerId(programmerId));

        return "list_info";
    }

    @GetMapping("/project_id")
    public String getByProjectId(@RequestParam("project_id") Integer projectId, Model model) {
        model.addAttribute("items", dao.getByProjectId(projectId));

        return "list_info";
    }

    @PostMapping("/new")
    @ResponseBody
    public String createNew(Technology technology) {
        if (dao.save(technology) > 0) {
            return "Inserted successfully";
        } else {
            return "Error during insert attempt";
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Technology technology) {
        if (dao.update(technology) > 0) {
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
