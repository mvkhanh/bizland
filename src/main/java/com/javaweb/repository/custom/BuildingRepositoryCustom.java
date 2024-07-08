package com.javaweb.repository.custom;

import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(BuildingSearchRequest searchDTO);
}
