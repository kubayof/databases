package com.naofi.controllers;

import com.naofi.model.dao.interfaces.ProgrammerTechnologyDAO;
import com.naofi.model.entity.ProgrammerTechnology;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programmers_technologies")
public class ProgrammersTechnologiesController {
    private final ProgrammerTechnologyDAO dao;

    public ProgrammersTechnologiesController(ProgrammerTechnologyDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/programmer_id")
    public List<ProgrammerTechnology> getByProgrammerId(@RequestParam("programmer_id") Integer programmerId) {
        return dao.getByProgrammerId(programmerId);
    }

    @GetMapping("/technology_id")
    public List<ProgrammerTechnology> getByTechnologyId(@RequestParam("technology_id") Integer technologyId) {
        return dao.getByTechnologyId(technologyId);
    }

    @GetMapping("/id")
    public ProgrammerTechnology getById(@RequestParam("programmer_id") Integer programmerId,
                                        @RequestParam("technology_id") Integer technologyId) {
        return dao.getById(programmerId, technologyId);
    }

    @PostMapping("/new")
    public String createNew(ProgrammerTechnology entity) {
        if (dao.save(entity) > 0) {
            return "Successfully inserted";
        } else {
            return "Error during insert attempt";
        }
    }

    @DeleteMapping("/delete")
    public String delete(ProgrammerTechnology entity) {
        if (dao.delete(entity) > 0) {
            return "Successfully deleted";
        } else {
            return "Error while delete attempt";
        }
    }
}
