package com.javaweb.repository;

import com.javaweb.repository.custom.RepositoryCustom;
import com.javaweb.repository.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository<E extends BaseEntity, S> extends JpaRepository<E, Integer>, RepositoryCustom<E, S> {
}
