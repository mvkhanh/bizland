package com.javaweb.service;

import com.javaweb.model.request.BuildingAssignmentRequest;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBuildingService {
    Page<BuildingSearchResponse> findAll(BuildingSearchRequest searchDTO);
    BuildingDTO findById(Integer id);
    void addOrUpdate(BuildingDTO dto);
    void delete(List<Integer> ids);
    Response getStaffs(Integer id);
    void assignBuilding(BuildingAssignmentRequest request);
}