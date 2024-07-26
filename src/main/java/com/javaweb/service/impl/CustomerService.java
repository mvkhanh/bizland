package com.javaweb.service.impl;

import com.javaweb.converter.CustomerConverter;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.AssignmentRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.Response;
import com.javaweb.repository.IRepository;
import com.javaweb.repository.IUserRepository;
import com.javaweb.repository.entity.CustomerEntity;
import com.javaweb.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final IRepository<CustomerEntity, CustomerSearchRequest> customerRepository;
    private final IUserRepository userRepository;
    private final CustomerConverter converter;
    @Override
    public Page<CustomerDTO> findAll(CustomerSearchRequest search) {
        return null;
    }

    @Override
    public CustomerDTO findById(Integer id) {
        return null;
    }

    @Override
    public void addOrUpdate(CustomerDTO dto) {

    }

    @Override
    public void delete(List<Integer> ids) {

    }

    @Override
    public Response getStaffs(Integer id) {
        return null;
    }

    @Override
    public void assignCustomer(AssignmentRequest request) {

    }
}
