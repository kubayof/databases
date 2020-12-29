package com.naofi.controllers;

import com.naofi.model.entity.Programmer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/programmers")
public class ProgrammerEntityController {
    private final SessionFactory factory;

    public ProgrammerEntityController(SessionFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/id")
    public String getById(@RequestParam Integer id, Model model) {
        model.addAttribute("type", "programmer");
        model.addAttribute("programmer", Optional.of((Programmer)factory.getCurrentSession().get(Programmer.class, id))
                .orElseThrow(NullPointerException::new));

        return "info/info_template";
    }

    @PostMapping("/new")
    @ResponseBody
    public String createNew(Programmer programmer) {
        factory.getCurrentSession().save(programmer);
        return "Successfully inserted";
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Programmer programmer) {
        factory.getCurrentSession().update(programmer);
        return "Successfully inserted";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") Integer id) {
        Session session = factory.getCurrentSession();
        session.delete(session.get(Programmer.class, id));
        return "Deleted successfully";
    }
}
