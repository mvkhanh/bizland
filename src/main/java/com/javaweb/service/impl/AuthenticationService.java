package com.javaweb.service.impl;

import com.javaweb.enums.Role;
import com.javaweb.model.request.RegisterRequest;
import com.javaweb.repository.IUserRepository;
import com.javaweb.repository.entity.UserEntity;
import com.javaweb.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {
    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(RegisterRequest registerRequest) {
        String username = registerRequest.getUsername();
        if(repository.existsByUsernameAndDeleted(username, false)) throw new DataIntegrityViolationException("Username already exists");
        UserEntity entity = UserEntity.builder()
                .email(registerRequest.getEmail())
                .phone(registerRequest.getPhone())
                .roles(Role.USER.name())
                .username(username)
                .fullName(registerRequest.getFullName())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        return repository.save(entity);
    }
}
