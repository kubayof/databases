package com.naofi.controllers;

import com.naofi.model.DataGenerator;
import com.naofi.util.IdGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
    private final DataGenerator generator;

    public IndexController(DataGenerator generator) {
        this.generator = generator;
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
                           @RequestParam("projects_technologies_count") Integer projectsTechnologiesCount) {
        generator.populate(managersCount, technologiesCount, projectsCount,
                programmersCount, projectsTechnologiesCount, programmersTechnologiesCount);
        return new RedirectView("/");
    }
}
