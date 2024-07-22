package com.javaweb.service;

import com.javaweb.model.request.RegisterRequest;
import com.javaweb.repository.entity.UserEntity;

import java.util.Map;

public interface IUserService {
    Map<Integer, String> findAllStaff();
    UserEntity createUser(RegisterRequest registerRequest);
}
