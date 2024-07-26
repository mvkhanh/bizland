package com.javaweb.controller;

import com.javaweb.enums.Role;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.request.UserSearchRequest;
import com.javaweb.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserController {
    private final IUserService service;

    @GetMapping("/users")
    public ModelAndView list(@ModelAttribute("search") UserSearchRequest search){
        ModelAndView mav = new ModelAndView("admin/user/list");
        mav.addObject("roles", Role.getRoles());
        mav.addObject("result", service.findAll(search));
        return mav;
    }

    @GetMapping("/users-edit")
    public ModelAndView add(@ModelAttribute("user") UserDTO dto, HttpServletRequest request){
        return new ModelAndView("admin/user/edit", "roles", Role.getRoles());
    }

    @GetMapping("/users-edit-{id}")
    public ModelAndView edit(@PathVariable Integer id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/user/edit", "roles", Role.getRoles());
        mav.addObject("user", service.findById(id));
        return mav;
    }
}
