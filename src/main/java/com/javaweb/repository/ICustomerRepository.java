package com.javaweb.repository;

import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.custom.RepositoryCustom;
import com.javaweb.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Integer>, RepositoryCustom<CustomerEntity, CustomerSearchRequest> {
}
