package com.naofi.controllers;

import com.naofi.model.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("projects")
public class ProjectEntityController {
    private final SessionFactory factory;

    public ProjectEntityController(SessionFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/id")
    public String getById(@RequestParam Integer id, Model model) {
        model.addAttribute("type", "project");
        model.addAttribute("project", Optional.of((Project)factory.getCurrentSession().get(Project.class, id))
                .orElseThrow(NullPointerException::new));

        return "info/info_template";
    }

    @PostMapping("/new")
    @ResponseBody
    public String createNew(Project project) {
        factory.getCurrentSession().save(project);
        return "Inserted successfully";
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Project project) {
        factory.getCurrentSession().update(project);
        return "Updated successfully";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") Integer id) {
        Session session = factory.getCurrentSession();
        session.delete(session.get(Project.class, id));
        return "Successfully deleted";
    }
}
