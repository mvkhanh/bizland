package com.javaweb.service;

import com.javaweb.model.request.BuildingAssignmentRequest;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.Response;

import java.util.List;

public interface IBuildingService {
    List<BuildingSearchResponse> findAll(BuildingSearchRequest searchDTO);
    BuildingDTO findById(Integer id);
    void addOrUpdate(BuildingDTO dto);
    void delete(List<Integer> ids);
    Response getStaffs(Integer id);
    void assignBuilding(BuildingAssignmentRequest request);
}