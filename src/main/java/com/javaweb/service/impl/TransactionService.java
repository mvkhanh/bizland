package com.javaweb.service.impl;

import com.javaweb.converter.TransactionConverter;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.ICustomerRepository;
import com.javaweb.repository.ITransactionRepository;
import com.javaweb.repository.entity.TransactionEntity;
import com.javaweb.security.utils.UserSecurityUtil;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {
    private final ITransactionRepository repository;
    private final TransactionConverter converter;
    private final ICustomerRepository customerRepository;

    @Override
    public List<TransactionEntity> find(Integer id, String code) {
        return repository.findByCodeAndCustomerIdAndDeleted(code, id, false);
    }

    @Override
    public void addOrUpdate(TransactionDTO dto) {
        TransactionEntity entity = converter.DTOToEntity(dto);
        entity.setCustomer(customerRepository.findById(dto.getCustomerId()).get());
        if(dto.getId() == null){
            entity.setCreatedBy(UserSecurityUtil.getUserDetail().getFullName());
            entity.setCreatedDate(LocalDate.now());
        }
        else{
            TransactionEntity existEntity = repository.findById(dto.getId()).get();
            entity.setCreatedBy(existEntity.getCreatedBy());
            entity.setCreatedDate(existEntity.getCreatedDate());
            entity.setModifiedBy(UserSecurityUtil.getUserDetail().getFullName());
            entity.setModifiedDate(LocalDate.now());
        }
        repository.save(entity);
    }

    @Override
    public void delete(List<Integer> ids) {
        repository.findAllById(ids).forEach(i -> {
            i.setDeleted(true);
            repository.save(i);
        });
    }
}
