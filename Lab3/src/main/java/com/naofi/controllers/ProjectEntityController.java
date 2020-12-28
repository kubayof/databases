package com.naofi.controllers;

import com.naofi.model.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("projects")
public class ProjectEntityController {
    private final SessionFactory factory;

    public ProjectEntityController(SessionFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/id")
    public Project getById(@RequestParam Integer id) {
        return Optional.of((Project)factory.getCurrentSession().get(Project.class, id))
                .orElseThrow(NullPointerException::new);
    }

    @PostMapping("/new")
    public String createNew(Project project) {
        factory.getCurrentSession().save(project);
        return "Inserted successfully";
    }

    @PostMapping("/update")
    public String update(Project project) {
        factory.getCurrentSession().update(project);
        return "Updated successfully";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        Session session = factory.getCurrentSession();
        session.delete(session.get(Project.class, id));
        return "Successfully deleted";
    }
}
