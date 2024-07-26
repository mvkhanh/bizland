package com.javaweb.service;

import com.javaweb.model.request.RegisterRequest;
import com.javaweb.repository.entity.UserEntity;

public interface IAuthenticationService {
    UserEntity createUser(RegisterRequest registerRequest);
}
