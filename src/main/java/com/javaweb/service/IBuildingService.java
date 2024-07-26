package com.javaweb.service;

import com.javaweb.model.request.AssignmentRequest;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.Response;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBuildingService {
    Page<BuildingSearchResponse> findAll(BuildingSearchRequest searchDTO);
    BuildingDTO findById(Integer id);
    void addOrUpdate(BuildingDTO dto);
    void delete(List<Integer> ids);
    Response getStaffs(Integer id);
    void assignBuilding(AssignmentRequest request);
}