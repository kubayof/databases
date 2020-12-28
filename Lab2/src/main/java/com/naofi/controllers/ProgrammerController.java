package com.naofi.controllers;

import com.naofi.model.dao.interfaces.ProgrammerDAO;
import com.naofi.model.entity.Programmer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/programmers")
public class ProgrammerController {
    private final ProgrammerDAO dao;

    public ProgrammerController(ProgrammerDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/id")
    @ResponseBody
    public Programmer getById(@RequestParam Integer id) {
        Programmer programmer = dao.getById(id);
        if (programmer == null) {
            throw new NullPointerException();
        }
        return programmer;
    }

    @GetMapping("/first_name")
    public String getByFirstName(@RequestParam("first_name") String firstName, Model model) {
        model.addAttribute("items", dao.getByFirstName(firstName));

        return "list_info";
    }

    @GetMapping("/last_name")
    public String getByLastName(@RequestParam("last_name") String lastName, Model model) {
        model.addAttribute("items", dao.getByLastName(lastName));

        return "list_info";
    }

    @GetMapping("/manager_id")
    public String getByManagerId(@RequestParam("manager_id") Integer managerId, Model model) {
        model.addAttribute("items", dao.getByManagerId(managerId));

        return "list_info";
    }

    @GetMapping("/technology_id")
    public String getByTechnologyId(@RequestParam("technology_id") Integer technologyId, Model model) {
        model.addAttribute("items", dao.getByTechnologyId(technologyId));

        return "list_info";
    }

    @PostMapping("/new")
    @ResponseBody
    public String createNew(Programmer programmer) {
        if (dao.save(programmer) > 0) {
            return "Successfully inserted";
        } else {
            return "Error while insert attempt";
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Programmer programmer) {
        if (dao.update(programmer) > 0) {
            return "Successfully inserted";
        } else {
            return  "Error while insert attempt";
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") Integer id) {
        if (dao.deleteById(id) > 0) {
            return "Deleted successfully";
        } else {
            return "Error during delete attempt";
        }
    }
}
