package com.javaweb.converter;

import com.javaweb.enums.District;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.utils.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BuildingSearchResponse EntityToSearchResponse(BuildingEntity entity) {
        BuildingSearchResponse model = modelMapper.map(entity, BuildingSearchResponse.class);
        if(!entity.getDistrict().isBlank())
            model.setAddress(entity.getStreet() + ", " + entity.getWard() + ", " + District.valueOf(entity.getDistrict()).getName());
        if(!entity.getRentAreas().isEmpty())
            model.setRentAreas(entity.getRentAreas().stream().map(i -> i.getValue().toString()).collect(Collectors.joining(", ")));
        else model.setRentAreas("");
        return model;
    }
    public BuildingEntity DTOToEntity(BuildingDTO dto){
        BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
        if(!dto.getRentAreas().isBlank())
            entity.setRentAreas(Arrays.stream(dto.getRentAreas().split(", ")).map(i -> {
                RentAreaEntity area = new RentAreaEntity();
                area.setBuilding(entity);
                area.setValue(Integer.valueOf(i));
                return area;
            }).toList());
        entity.setTypeCodes(String.join(",", dto.getTypeCodes()));
        entity.setImage(FileUtil.FileToByte(dto.getImageFile()));
        return entity;
    }
    public BuildingDTO EntityToDTO(BuildingEntity entity){
        BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
        dto.setRentAreas(entity.getRentAreas().stream().map(i -> i.getValue().toString()).collect(Collectors.joining(", ")));
        dto.setTypeCodes(Arrays.stream(entity.getTypeCodes().split(",")).toList());
        dto.setImageFile(FileUtil.ByteToFile(entity.getImage()));
        return dto;
    }
}