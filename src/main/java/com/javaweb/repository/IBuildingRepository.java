package com.javaweb.repository;

import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.RepositoryCustom;
import com.javaweb.repository.entity.BaseEntity;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBuildingRepository extends JpaRepository<BuildingEntity, Integer>, RepositoryCustom<BuildingEntity, BuildingSearchRequest> {
}
