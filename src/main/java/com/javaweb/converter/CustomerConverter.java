package com.javaweb.converter;

import com.javaweb.enums.CustomerStatus;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.repository.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerConverter {
    private final ModelMapper modelMapper;

    public CustomerDTO EntityToDTO(CustomerEntity entity){
        return modelMapper.map(entity, CustomerDTO.class);
    }

    public CustomerEntity DTOToEntity(CustomerDTO dto){
        return modelMapper.map(dto, CustomerEntity.class);
    }

    public CustomerSearchResponse EntityToSearchResponse(CustomerEntity entity){
        CustomerSearchResponse response = modelMapper.map(entity, CustomerSearchResponse.class);
        response.setStatus(CustomerStatus.valueOf(response.getStatus()).getValue());
        return response;
    }
}
