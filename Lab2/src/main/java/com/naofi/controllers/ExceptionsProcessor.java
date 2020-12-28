package com.naofi.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class ExceptionsProcessor {
    @ExceptionHandler({Exception.class})
    public String handleException(Exception e, Model model) {
         model.addAttribute("message", e.getMessage());

         return "error";
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(DataIntegrityViolationException e, Model model) {
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream();
             PrintWriter writer = new PrintWriter(bout)) {
            Throwable t = e;
            do {
                writer.println(t.getMessage() + "<br/>");
            } while ((t = t.getCause()) != null);
            writer.flush();
            model.addAttribute("message", bout.toString());
        } catch (IOException e1) {
            model.addAttribute("message", "Error during attempt to write exception info");
        }

        return "error";
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String handleNullPointerException(Model model) {
        return "Empty";
    }
}
