package com.javaweb.controller;

import com.javaweb.enums.Role;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.security.utils.UserSecurityUtil;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.IUserService;
import com.javaweb.utils.FileUtil;
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
public class CustomerController {
    private final ICustomerService customerService;
    private final IUserService userService;

    @GetMapping("/customers")
    public ModelAndView getList(@ModelAttribute("search") CustomerSearchRequest search){
        ModelAndView mav = new ModelAndView("admin/customer/list");
        if(UserSecurityUtil.getRoles().contains(Role.STAFF.name())) search.setId_staff(UserSecurityUtil.getUserDetail().getId());
        mav.addObject("result", customerService.findAll(search));
        mav.addObject("staffs", userService.findAllStaff());
        return mav;
    }

    @GetMapping("/customers-edit")
    public ModelAndView add(@ModelAttribute("customer") BuildingDTO dto, HttpServletRequest request){
        return new ModelAndView("admin/customer/edit", "staffs", userService.findAllStaff());
    }

    @GetMapping("/customers-edit-{id}")
    public ModelAndView edit(@PathVariable Integer id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("customer", customerService.findById(id));
        mav.addObject("staffs", userService.findAllStaff());
        return mav;
    }
}
