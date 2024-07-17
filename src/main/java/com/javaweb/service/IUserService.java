package com.javaweb.service;

import com.javaweb.model.request.RegisterRequest;
import com.javaweb.repository.entity.UserEntity;

import java.util.Map;
import java.util.Optional;

public interface IUserService {
    Map<Integer, String> findAllStaff();
    UserEntity createUser(RegisterRequest registerRequest);
    String login(String username, String password);
}
