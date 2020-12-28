package com.naofi.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionsProcessor {
    @ExceptionHandler({Exception.class})
    public String handleException(Exception e, Model model) {
         model.addAttribute("message", e.getMessage());

         return "error";
    }

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException e) {
        return "SQL exception occurred";
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String handleNullPointerException(Model model) {
        return "Empty";
    }
}
