package com.javaweb.repository;

import com.javaweb.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAllByStatusAndRolesContaining(Integer status, String role);
    UserEntity findByUsernameAndStatus(String username, Integer status);
    boolean existsByUsername(String username);
}
