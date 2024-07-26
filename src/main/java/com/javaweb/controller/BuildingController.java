package com.javaweb.controller;

import com.javaweb.enums.District;
import com.javaweb.enums.Role;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import com.javaweb.utils.FileUtil;
import com.javaweb.security.utils.UserSecurityUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class BuildingController {
    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IUserService userService;
    private final Map<String, Object> models = new HashMap<>();

    public BuildingController(){
        models.put("districts", District.getDistricts());
        models.put("typecodes", TypeCode.getTypecodes());
    }
    @GetMapping("/buildings")
    public ModelAndView getList(@ModelAttribute("search") BuildingSearchRequest search){
        ModelAndView mav = new ModelAndView("admin/building/list", models);
        if(UserSecurityUtil.getRoles().contains(Role.STAFF.name())) search.setId_staff(UserSecurityUtil.getUserDetail().getId());
        mav.addObject("result", buildingService.findAll(search));
        mav.addObject("staffs", userService.findAllStaff());
        return mav;
    }

    @GetMapping("/buildings-edit")
    public ModelAndView add(@ModelAttribute("building") BuildingDTO dto, HttpServletRequest request){
        return new ModelAndView("admin/building/edit", models);
    }

    @GetMapping("/buildings-edit-{id}")
    public ModelAndView edit(@PathVariable Integer id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit", models);
        BuildingDTO buildingDTO = buildingService.findById(id);
        mav.addObject("building", buildingDTO);
        mav.addObject("image", FileUtil.FileToImage(buildingDTO.getImageFile()));
        return mav;
    }
}
