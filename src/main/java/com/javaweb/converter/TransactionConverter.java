package com.javaweb.converter;

import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.entity.TransactionEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionConverter {
    private final ModelMapper modelMapper;

    public TransactionEntity DTOToEntity(TransactionDTO dto){
        return modelMapper.map(dto, TransactionEntity.class);
    }
}
