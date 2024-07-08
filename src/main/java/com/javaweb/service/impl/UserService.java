package com.javaweb.service.impl;

import com.javaweb.repository.IUserRepository;
import com.javaweb.repository.entity.UserEntity;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Override
    public Map<Integer, String> findAllStaff() {
        return repository.findAllByStatusAndRoles_code(1, "STAFF").stream()
            .collect(Collectors.toMap(
                    UserEntity::getId,
                    UserEntity::getFullName
            ));
    }
}
