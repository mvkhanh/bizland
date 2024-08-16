package com.javaweb.service.impl;

import com.javaweb.converter.CustomerConverter;
import com.javaweb.enums.Role;
import com.javaweb.enums.TransactionType;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.AssignmentRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.model.response.Response;
import com.javaweb.model.response.StaffResponse;
import com.javaweb.repository.ICustomerRepository;
import com.javaweb.repository.IUserRepository;
import com.javaweb.repository.entity.CustomerEntity;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;
    private final IUserRepository userRepository;
    private final ITransactionService transactionService;
    private final CustomerConverter converter;

    @Override
    public Page<CustomerSearchResponse> findAll(CustomerSearchRequest search) {
        Page<CustomerEntity> results = customerRepository.findAll(search, PageRequest.of(search.getPageNumber(), search.getPageSize()), CustomerEntity.class);
        return results.map(converter::EntityToSearchResponse);
    }

    @Override
    public CustomerDTO findById(Integer id) {
        CustomerDTO dto = converter.EntityToDTO(customerRepository.findById(id).get());
        Arrays.stream(TransactionType.values()).forEach(i -> dto.getTransactions().put(Pair.of(i.name(), i.getName()), transactionService.find(id, i.name())));
        return dto;
    }

    @Override
    public void addOrUpdate(CustomerDTO dto) {
        CustomerEntity entity = converter.DTOToEntity(dto);
        if(dto.getId() != null){
            CustomerEntity existBuilding = customerRepository.findById(dto.getId()).get();
            entity.setStaffs(existBuilding.getStaffs());
        }
        customerRepository.save(entity);
    }

    @Override
    public void delete(List<Integer> ids) {
        customerRepository.findAllById(ids).forEach(customer -> {
            customer.setDeleted(true);
            customerRepository.save(customer);
        });
    }

    @Override
    public Response getStaffs(Integer id) {
        List<StaffResponse> staffResponses = new ArrayList<>();
        userRepository.findAllByDeletedAndRolesContaining(false, Role.STAFF.name()).forEach(
                staff -> staffResponses.add(new StaffResponse(staff.getId(), staff.getFullName(), customerRepository.findById(id).get().getStaffs().contains(staff) ? "checked" : "")));
        return new Response.RequestBuilder().data(staffResponses).build();
    }

    @Override
    public void assignCustomer(AssignmentRequest request) {
        CustomerEntity customer = customerRepository.findById(request.getId()).get();
        customer.setStaffs(userRepository.findAllById(request.getStaffIds()));
        customerRepository.save(customer);
    }
}
