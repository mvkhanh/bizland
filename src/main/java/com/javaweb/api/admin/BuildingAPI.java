package com.javaweb.api.admin;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.AssignmentRequest;
import com.javaweb.model.response.Response;
import com.javaweb.service.IBuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/buildings")
@RequiredArgsConstructor
public class BuildingAPI {
    private final IBuildingService service;

    @PostMapping
    public void addOrUpdate(@ModelAttribute BuildingDTO building){
        service.addOrUpdate(building);
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
    public void assignBuilding(@RequestBody AssignmentRequest assignmentRequest){
        service.assignBuilding(assignmentRequest);
    }
}
