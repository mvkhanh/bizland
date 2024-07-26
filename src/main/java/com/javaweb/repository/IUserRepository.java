package com.javaweb.repository;

import com.javaweb.model.request.UserSearchRequest;
import com.javaweb.repository.custom.RepositoryCustom;
import com.javaweb.repository.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>, RepositoryCustom<UserEntity, UserSearchRequest> {
    List<UserEntity> findAllByStatusAndRolesContaining(Integer status, String role);
    UserEntity findByUsernameAndStatus(String username, Integer status);
    boolean existsByUsername(String username);
}
