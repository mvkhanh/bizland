package com.javaweb.controller;

import com.javaweb.enums.District;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class BuildingController {
    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IUserService userService;

    @GetMapping("/buildings")
    public ModelAndView getList(@ModelAttribute("search") BuildingSearchRequest search){
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("result", buildingService.findAll(search));
        mav.addObject("staffs", userService.findAllStaff());
        mav.addObject("districts", District.getDistricts());
        mav.addObject("typecodes", TypeCode.getTypecodes());
        return mav;
    }

    @GetMapping("/buildings-edit")
    public ModelAndView add(@ModelAttribute("building") BuildingDTO dto, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("district", District.getDistricts());
        mav.addObject("typecodes", TypeCode.getTypecodes());
        return mav;
    }

    @GetMapping("/buildings-edit-{id}")
    public ModelAndView edit(@PathVariable Integer id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("building", buildingService.findById(id));
        mav.addObject("district", District.getDistricts());
        mav.addObject("typecodes", TypeCode.getTypecodes());
        return mav;
    }
}
