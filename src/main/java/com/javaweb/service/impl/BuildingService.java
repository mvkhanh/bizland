package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.enums.Role;
import com.javaweb.model.request.AssignmentRequest;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.Response;
import com.javaweb.model.response.StaffResponse;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.IUserRepository;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.repository.entity.BuildingEntity;

@Service
public class BuildingService implements IBuildingService {
    @Autowired
    private IBuildingRepository buildingRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Override
    public Page<BuildingSearchResponse> findAll(BuildingSearchRequest searchDTO) {
        Sort sort = Sort.by(Sort.Direction.fromString(searchDTO.getSortDirection()), searchDTO.getSortColumn());
        Pageable pageable = PageRequest.of(searchDTO.getPageNumber(), searchDTO.getPageSize(), sort);
        Page<BuildingEntity> results = buildingRepository.findAll(searchDTO, pageable, BuildingEntity.class);
        List<BuildingSearchResponse> responses = results.getContent().stream().map(buildingConverter::EntityToSearchResponse).toList();
        return new PageImpl<>(responses, results.getPageable(), results.getTotalElements());
    }

    @Override
    public BuildingDTO findById(Integer id) {
        return buildingConverter.EntityToDTO(buildingRepository.findById(id).get());
    }

    @Override
    public void addOrUpdate(BuildingDTO dto) {
        BuildingEntity entity = buildingConverter.DTOToEntity(dto);
        if(dto.getId() != null){
            BuildingEntity existBuilding = buildingRepository.findById(dto.getId()).get();
            if(dto.getImageFile() == null) entity.setImage(existBuilding.getImage());
            entity.setStaffs(existBuilding.getStaffs());
        }
        buildingRepository.save(entity);
    }

    @Override
    public void delete(List<Integer> ids) {
        buildingRepository.findAllById(ids).forEach(i -> {
            i.setDeleted(true);
            buildingRepository.save(i);
        });
    }

    @Override
    public Response getStaffs(Integer id) {
        List<StaffResponse> staffResponses = new ArrayList<>();
        userRepository.findAllByDeletedAndRolesContaining(false, Role.STAFF.name()).forEach(
                staff -> staffResponses.add(new StaffResponse(staff.getId(), staff.getFullName(), buildingRepository.findById(id).get().getStaffs().contains(staff) ? "checked" : "")));
        return new Response.RequestBuilder().data(staffResponses).build();
    }

    @Override
    public void assignBuilding(AssignmentRequest request) {
        BuildingEntity building = buildingRepository.findById(request.getId()).get();
        building.setStaffs(userRepository.findAllById(request.getStaffIds()));
        buildingRepository.save(building);
    }
}
