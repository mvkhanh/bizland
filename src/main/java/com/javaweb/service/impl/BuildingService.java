package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.enums.Role;
import com.javaweb.model.request.BuildingAssignmentRequest;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.Response;
import com.javaweb.model.response.StaffResponse;
import com.javaweb.repository.IUserRepository;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.repository.IBuildingRepository;
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
        Page<BuildingEntity> results = buildingRepository.findAll(searchDTO, PageRequest.of(searchDTO.getPageNumber(), searchDTO.getPageSize()));
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
        if(dto.getId() != null && dto.getImageFile() == null) entity.setImage(buildingRepository.findById(dto.getId()).get().getImage());
        buildingRepository.save(entity);
    }

    @Override
    public void delete(List<Integer> ids) {
        buildingRepository.deleteAllById(ids);
    }

    @Override
    public Response getStaffs(Integer id) {
        List<StaffResponse> staffResponses = new ArrayList<>();
        userRepository.findAllByStatusAndRolesContaining(1, Role.STAFF.name()).forEach(
                staff -> staffResponses.add(new StaffResponse(staff.getId(), staff.getFullName(), buildingRepository.findById(id).get().getUsers().contains(staff) ? "checked" : "")));
        return new Response.RequestBuilder().data(staffResponses).build();
    }

    @Override
    public void assignBuilding(BuildingAssignmentRequest request) {
        BuildingEntity building = buildingRepository.findById(request.getBuildingId()).get();
        building.setUsers(userRepository.findAllById(request.getStaffIds()));
        buildingRepository.save(building);
    }
}
