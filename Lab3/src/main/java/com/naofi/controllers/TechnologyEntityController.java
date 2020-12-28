package com.naofi.controllers;

import com.naofi.model.entity.Technology;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/technologies")
public class TechnologyEntityController {
    private final SessionFactory factory;

    public TechnologyEntityController(SessionFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/id")
    public Technology getById(@RequestParam Integer id) {
        return Optional.of((Technology)factory.getCurrentSession().get(Technology.class, id))
                .orElseThrow(NullPointerException::new);
    }

    @PostMapping("/new")
    public String createNew(Technology technology) {
        factory.getCurrentSession().save(technology);
        return "Inserted successfully";
    }

    @PostMapping("/update")
    public String update(Technology technology) {
        factory.getCurrentSession().update(technology);
        return "Updated successfully";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        Session session = factory.getCurrentSession();
        session.delete(session.get(Technology.class, id));
        return "Deleted successfully";
    }
}
