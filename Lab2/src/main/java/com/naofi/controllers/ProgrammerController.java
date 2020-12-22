package com.naofi.controllers;

import com.naofi.model.dao.interfaces.ProgrammerDAO;
import com.naofi.model.entity.Programmer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programmers")
public class ProgrammerController {
    private final ProgrammerDAO dao;

    public ProgrammerController(ProgrammerDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/id")
    public Programmer getById(@RequestParam Integer id) {
        return dao.getById(id);
    }

    @GetMapping("/first_name")
    public List<Programmer> getByFirstName(@RequestParam("first_name") String firstName) {
        return dao.getByFirstName(firstName);
    }

    @GetMapping("/last_name")
    public List<Programmer> getByLastName(@RequestParam("last_name") String lastName) {
        return dao.getByLastName(lastName);
    }

    @GetMapping("/manager_id")
    public List<Programmer> getByManagerId(@RequestParam("id") Integer managerId) {
        return dao.getByManagerId(managerId);
    }

    @GetMapping("/technology_id")
    public List<Programmer> getByTechnologyId(@RequestParam("id") Integer technologyId) {
        return dao.getByTechnologyId(technologyId);
    }

    @PostMapping("/new")
    public String createNew(Programmer programmer) {
        if (dao.save(programmer) > 0) {
            return "Successfully inserted";
        } else {
            return "Error while insert attempt";
        }
    }

    @PostMapping("/update")
    public String update(Programmer programmer) {
        if (dao.update(programmer) > 0) {
            return "Successfully inserted";
        } else {
            return  "Error while insert attempt";
        }
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        if (dao.deleteById(id) > 0) {
            return "Deleted successfully";
        } else {
            return "Error during delete attempt";
        }
    }
}
