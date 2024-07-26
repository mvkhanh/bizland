package com.javaweb.converter;

import com.javaweb.model.dto.UserDTO;
import com.javaweb.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

//bỏ lớp này dùng thẳng trong service luôn
@Component
@RequiredArgsConstructor
public class UserConverter {
    private final ModelMapper mapper;

    public UserDTO EntityToDTO(UserEntity entity){
        return mapper.map(entity, UserDTO.class);
    }

    public UserEntity DTOToEntity(UserDTO dto) {
        return mapper.map(dto, UserEntity.class);
    }
}
