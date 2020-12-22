package com.naofi.controllers;

import com.naofi.model.dao.interfaces.ManagerDAO;
import com.naofi.model.entity.Manager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/managers")
public class ManagerController {
    private final ManagerDAO dao;

    public ManagerController(ManagerDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/id")
    public Manager getById(@RequestParam Integer id) {
        return dao.getById(id);
    }

    @GetMapping("/first_name")
    public List<Manager> getByFirstName(@RequestParam("first_name") String firstName) {
        return dao.getByFirstName(firstName);
    }

    @GetMapping("/last_name")
    public List<Manager> getByLastName(@RequestParam("last_name") String lastName) {
        return dao.getByLastName(lastName);
    }

    @GetMapping("/project_id")
    public Manager getByProjectId(@RequestParam Integer projectId) {
        return dao.getByProjectId(projectId);
    }

    @GetMapping("/programmer_id")
    public Manager getByProgrammerId(@RequestParam Integer programmerId) {
        return dao.getByProgrammerId(programmerId);
    }

    @PostMapping("/new")
    public String createNew(Manager manager) {
        if (dao.save(manager) > 0) {
            return "Successfully inserted";
        } else {
            return "Error while insert attempt";
        }
    }

    @PostMapping("/update")
    public String update(Manager manager) {
        if (dao.update(manager) > 0) {
            return "Updated successfully";
        } else {
            return "Error while updating";
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
