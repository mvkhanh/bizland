package com.javaweb.service;

import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.AssignmentRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.Response;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerService {
    Page<CustomerDTO> findAll(CustomerSearchRequest search);
    CustomerDTO findById(Integer id);
    void addOrUpdate(CustomerDTO dto);
    void delete(List<Integer> ids);
    Response getStaffs(Integer id);
    void assignCustomer(AssignmentRequest request);
}
