package com.javaweb.api.admin;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingAssignmentRequest;
import com.javaweb.model.response.Response;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/buildings")
public class BuildingAPI {
    @Autowired
    IBuildingService service;

    @PostMapping
    public void addOrUpdate(@ModelAttribute BuildingDTO dto){
        service.addOrUpdate(dto);
    }

    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Integer> ids){
        service.delete(ids);
    }

    @GetMapping("/{id}/staffs")
    public Response getStaffs(@PathVariable Integer id){

        return service.getStaffs(id);
    }

    @PutMapping("/assignment")
    public void assignBuilding(@RequestBody BuildingAssignmentRequest assignmentRequest){
        service.assignBuilding(assignmentRequest);
    }
}
