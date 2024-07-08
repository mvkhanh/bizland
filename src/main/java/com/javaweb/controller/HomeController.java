package com.javaweb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class HomeController {
    @GetMapping("/home")
    public ModelAndView getList(HttpServletRequest request){
        return new ModelAndView("admin/home");
    }
}