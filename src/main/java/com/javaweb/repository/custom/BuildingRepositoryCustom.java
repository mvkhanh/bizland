package com.javaweb.repository.custom;

import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {
    /*Page<BuildingEntity> findAll(BuildingSearchRequest searchDTO, Pageable pageable);*/
    Page<BuildingEntity> findAll(BuildingSearchRequest searchDTO, Pageable pageable);
}
