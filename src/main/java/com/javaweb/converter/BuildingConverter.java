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
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BuildingSearchResponse EntityToSearchResponse(BuildingEntity entity) {
        BuildingSearchResponse model = modelMapper.map(entity, BuildingSearchResponse.class);
        model.setAddress(Stream.of(entity.getStreet(), entity.getWard(), StringUtils.hasText(entity.getDistrict()) ? District.valueOf(entity.getDistrict()).getName() : null)
                .filter(StringUtils::hasText).collect(Collectors.joining(", ")));
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
        entity.setTypeCodes(String.join(",", dto.getTypeCodes().stream().map(i -> i.replaceAll("[\"\\[\\]]", "")).toList()));
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