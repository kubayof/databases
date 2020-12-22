package com.naofi.controllers;

import com.naofi.util.IdGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String getIndex(Model model, IdGenerator gen) {
        model.addAttribute("gen", gen);
        return "index";
    }
}
