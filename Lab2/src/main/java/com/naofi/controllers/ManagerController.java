package com.naofi.controllers;

import com.naofi.model.dao.interfaces.ManagerDAO;
import com.naofi.model.entity.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/managers")
public class ManagerController {
    private final ManagerDAO dao;

    public ManagerController(ManagerDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/id")
    @ResponseBody
    public Manager getById(@RequestParam Integer id) {
        Manager manager = dao.getById(id);
        if (manager == null) {
            throw new NullPointerException();
        }
        return manager;
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

    @GetMapping("/project_id")
    @ResponseBody
    public Manager getByProjectId(@RequestParam("project_id") Integer projectId) {
        Manager manager = dao.getByProjectId(projectId);
        if (manager == null) {
            throw new NullPointerException();
        }
        return manager;
    }

    @GetMapping("/programmer_id")
    @ResponseBody
    public Manager getByProgrammerId(@RequestParam("programmer_id") Integer programmerId) {
        Manager manager = dao.getByProgrammerId(programmerId);
        if (manager == null) {
            throw new NullPointerException();
        }
        return manager;
    }

    @PostMapping("/new")
    @ResponseBody
    public String createNew(Manager manager) {
        if (dao.save(manager) > 0) {
            return "Successfully inserted";
        } else {
            return "Error while insert attempt";
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Manager manager) {
        if (dao.update(manager) > 0) {
            return "Updated successfully";
        } else {
            return "Error while updating";
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
