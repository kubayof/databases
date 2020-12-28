package com.naofi.controllers;

import com.naofi.model.dao.interfaces.ProgrammerTechnologyDAO;
import com.naofi.model.entity.ProgrammerTechnology;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/programmers_technologies")
public class ProgrammersTechnologiesController {
    private final ProgrammerTechnologyDAO dao;

    public ProgrammersTechnologiesController(ProgrammerTechnologyDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/programmer_id")
    public String getByProgrammerId(@RequestParam("programmer_id") Integer programmerId, Model model) {
        model.addAttribute("items", dao.getByProgrammerId(programmerId));

        return "list_info";
    }

    @GetMapping("/technology_id")
    public String getByTechnologyId(@RequestParam("technology_id") Integer technologyId, Model model) {
        model.addAttribute("intems", dao.getByTechnologyId(technologyId));

        return "list_info";
    }

    @GetMapping("/id")
    @ResponseBody
    public ProgrammerTechnology getById(@RequestParam("programmer_id") Integer programmerId,
                                        @RequestParam("technology_id") Integer technologyId) {
        ProgrammerTechnology programmerTechnology = dao.getById(programmerId, technologyId);
        if (programmerTechnology == null) {
            throw new NullPointerException();
        }
        return programmerTechnology;
    }

    @PostMapping("/new")
    @ResponseBody
    public String createNew(ProgrammerTechnology entity) {
        if (dao.save(entity) > 0) {
            return "Successfully inserted";
        } else {
            return "Error during insert attempt";
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(ProgrammerTechnology entity) {
        if (dao.delete(entity) > 0) {
            return "Successfully deleted";
        } else {
            return "Error while delete attempt";
        }
    }
}
