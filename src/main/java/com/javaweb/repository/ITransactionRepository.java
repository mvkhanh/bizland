package com.javaweb.repository;

import com.javaweb.repository.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<TransactionEntity, Integer> {
    List<TransactionEntity> findByCodeAndCustomerIdAndDeleted(String code, Integer customerId, boolean deleted);
}
