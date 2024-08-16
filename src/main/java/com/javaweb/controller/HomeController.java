package com.javaweb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/admin/home")
    public ModelAndView admin(HttpServletRequest request){
        return new ModelAndView("admin/home");
    }

    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        return new ModelAndView("login");
    }
}
