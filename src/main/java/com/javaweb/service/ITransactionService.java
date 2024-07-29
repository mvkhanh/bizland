package com.javaweb.service;

import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.entity.TransactionEntity;

import java.util.List;

public interface ITransactionService {
    List<TransactionEntity> find(Integer id, String code);
    void addOrUpdate(TransactionDTO dto);
    void delete(List<Integer> ids);
}
