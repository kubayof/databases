package com.naofi.controllers;

import com.naofi.model.entity.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/managers")
public class ManagerEntityController {
    private final SessionFactory factory;

    public ManagerEntityController(SessionFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/id")
    public Manager getById(@RequestParam Integer id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Manager result = (Manager) session.get(Manager.class, id);
        session.getTransaction().commit();
        return result;
    }

    @PostMapping("/new")
    public String createNew(Manager manager) {
        factory.getCurrentSession().save(manager);
        return "Successfully inserted";
    }

    @PostMapping("/update")
    public String update(Manager manager) {
        factory.getCurrentSession().update(manager);
        return "Successfully updated";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        Session session = factory.getCurrentSession();
        session.delete(session.get(Manager.class, id));
        return "Successfully deleted";
    }
}
