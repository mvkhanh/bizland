package com.javaweb.repository;

import com.javaweb.repository.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAllByStatusAndRolesContaining(Integer status, String role);
    UserEntity findByUsernameAndStatus(String username, Integer status);
    boolean existsByUsername(String username);
    Page<UserEntity> findByFullNameContainingAndRolesContainingAndPhoneContainingAndStatus(String fullName, String roles, String phone, Integer status, Pageable pageable);
    Page<UserEntity> findByStatus(Integer status, Pageable pageable);
}
