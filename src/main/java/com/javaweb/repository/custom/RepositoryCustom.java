package com.javaweb.repository.custom;

import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RepositoryCustom <E, S>{
    Page<E> findAll(S searchDTO, Pageable pageable, Class<E> entityClass);
}
