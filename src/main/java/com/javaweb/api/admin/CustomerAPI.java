package com.javaweb.api.admin;

import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.AssignmentRequest;
import com.javaweb.model.response.Response;
import com.javaweb.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/admin/customers")
@RequiredArgsConstructor
public class CustomerAPI {
    private final ICustomerService service;

    @PostMapping({"/admin/customers", "/contact"})
    public ResponseEntity<String> addOrUpdate(@ModelAttribute CustomerDTO dto){
        try {
            service.addOrUpdate(dto);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/admin/customers/{ids}")
    public void delete(@PathVariable List<Integer> ids){
        service.delete(ids);
    }

    @GetMapping("/admin/customers/{id}/staffs")
    public Response getStaffs(@PathVariable Integer id){
        return service.getStaffs(id);
    }

    @PutMapping("/admin/customers/assignment")
    public void assignCustomer(@RequestBody AssignmentRequest assignmentRequest){
        service.assignCustomer(assignmentRequest);
    }
}
