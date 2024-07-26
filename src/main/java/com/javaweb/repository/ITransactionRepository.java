package com.javaweb.repository;

import com.javaweb.repository.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<TransactionEntity, Integer> {
}
