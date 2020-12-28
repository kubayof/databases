package com.naofi.controllers;

import com.naofi.model.dao.interfaces.*;
import com.naofi.util.IdGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
    private final ManagerDAO managerDAO;
    private final ProgrammerDAO programmerDAO;
    private final ProgrammerTechnologyDAO programmerTechnologyDAO;
    private final ProjectDAO projectDAO;
    private final ProjectTechnologyDAO projectTechnologyDAO;
    private final TechnologyDAO technologyDAO;

    public IndexController(ManagerDAO managerDAO,
                           ProgrammerDAO programmerDAO,
                           ProgrammerTechnologyDAO programmerTechnologyDAO,
                           ProjectDAO projectDAO,
                           ProjectTechnologyDAO projectTechnologyDAO,
                           TechnologyDAO technologyDAO) {
        this.managerDAO = managerDAO;
        this.programmerDAO = programmerDAO;
        this.programmerTechnologyDAO = programmerTechnologyDAO;
        this.projectDAO = projectDAO;
        this.projectTechnologyDAO = projectTechnologyDAO;
        this.technologyDAO = technologyDAO;
    }

    @GetMapping("/")
    public String getIndex(Model model, IdGenerator gen) {
        model.addAttribute("gen", gen);
        return "index";
    }

    @PostMapping("/populate")
    public RedirectView populate(@RequestParam("managers_count") Integer managersCount,
                           @RequestParam("programmers_count") Integer programmersCount,
                           @RequestParam("projects_count") Integer projectsCount,
                           @RequestParam("technologies_count") Integer technologiesCount,
                           @RequestParam("programmers_technologies_count") Integer programmersTechnologiesCount,
                           @RequestParam("projects_technologies_count") Integer projectsTechnologiesCount,
                           Model model,
                           IdGenerator gen) {
        managerDAO.populate(managersCount);
        technologyDAO.populate(technologiesCount);
        projectDAO.populate(projectsCount);
        programmerDAO.populate(programmersCount);
        projectTechnologyDAO.populate(projectsTechnologiesCount);
        programmerTechnologyDAO.populate(programmersTechnologiesCount);

        return new RedirectView("/");
    }
}
