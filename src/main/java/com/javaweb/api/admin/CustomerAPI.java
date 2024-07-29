package com.javaweb.api.admin;

import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.AssignmentRequest;
import com.javaweb.model.response.Response;
import com.javaweb.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/customers")
@RequiredArgsConstructor
public class CustomerAPI {
    private final ICustomerService service;

    @PostMapping
    public void addOrUpdate(@ModelAttribute CustomerDTO dto){
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
    public void assignCustomer(@RequestBody AssignmentRequest assignmentRequest){
        service.assignCustomer(assignmentRequest);
    }
}
