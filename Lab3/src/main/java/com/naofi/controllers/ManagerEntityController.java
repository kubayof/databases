package com.naofi.controllers;

import com.naofi.model.entity.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/managers")
public class ManagerEntityController {
    private final SessionFactory factory;

    public ManagerEntityController(SessionFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/id")
    public String getById(@RequestParam Integer id, Model model) {
        model.addAttribute("type", "manager");
        model.addAttribute("manager", Optional.of((Manager) factory.getCurrentSession().get(Manager.class, id))
                .orElseThrow(NullPointerException::new));

        return "info/info_template";
    }

    @PostMapping("/new")
    @ResponseBody
    public String createNew(Manager manager) {
        factory.getCurrentSession().save(manager);
        return "Successfully inserted";
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Manager manager) {
        factory.getCurrentSession().update(manager);
        return "Successfully updated";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") Integer id) {
        Session session = factory.getCurrentSession();
        session.delete(session.get(Manager.class, id));
        return "Successfully deleted";
    }
}
