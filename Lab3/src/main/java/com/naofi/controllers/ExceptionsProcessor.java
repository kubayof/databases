package com.naofi.controllers;

import com.naofi.util.IdGenerator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.sql.SQLException;

@ControllerAdvice
public class ExceptionsProcessor {
    @ModelAttribute
    public void addModelAttributes(Model model, IdGenerator gen) {
        model.addAttribute("gen", gen);
    }

    @ExceptionHandler({Exception.class})
    public String handleException(Exception e, Model model) {
         model.addAttribute("message", e.getMessage());

         return "error";
    }

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException e) {
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream();
             PrintWriter writer = new PrintWriter(bout)) {
            do {
                writer.println("SQL exception:");
                writer.println(e.getMessage());
            } while ((e = e.getNextException()) != null);
            writer.flush();
            return bout.toString();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "SQL exception occurred";
        }
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String handleNullPointerException(Model model) {
        return "Empty";
    }
}
