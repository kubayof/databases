package com.naofi.controllers;

import com.naofi.model.entity.Technology;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/technologies")
public class TechnologyEntityController {
    private final SessionFactory factory;

    public TechnologyEntityController(SessionFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/id")
    public String getById(@RequestParam Integer id, Model model) {
        model.addAttribute("type", "project");
        model.addAttribute("project", Optional.of((Technology)factory.getCurrentSession().get(Technology.class, id))
                .orElseThrow(NullPointerException::new));

        return "info/info_template";
    }


    @PostMapping("/new")
    @ResponseBody
    public String createNew(Technology technology) {
        factory.getCurrentSession().save(technology);
        return "Inserted successfully";
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Technology technology) {
        factory.getCurrentSession().update(technology);
        return "Updated successfully";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") Integer id) {
        Session session = factory.getCurrentSession();
        session.delete(session.get(Technology.class, id));
        return "Deleted successfully";
    }
}
