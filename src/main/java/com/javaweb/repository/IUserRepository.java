package com.javaweb.repository;

import com.javaweb.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAllByStatusAndRoles_code(Integer status, String roles_code);
}
