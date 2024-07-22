package com.javaweb.service.impl;

import com.javaweb.enums.Role;
import com.javaweb.model.request.RegisterRequest;
import com.javaweb.repository.IUserRepository;
import com.javaweb.repository.entity.UserEntity;
import com.javaweb.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;
//    private final JwtUtil jwtUtil;
//    private final AuthenticationManager authenticationManager;

    @Override
    public Map<Integer, String> findAllStaff() {
        return repository.findAllByStatusAndRolesContaining(1, Role.STAFF.name()).stream()
            .collect(Collectors.toMap(
                    UserEntity::getId,
                    UserEntity::getFullName
            ));
    }

    @Override
    public UserEntity createUser(RegisterRequest registerRequest) {
        String username = registerRequest.getUsername();
        if(repository.existsByUsername(username)) throw new DataIntegrityViolationException("Username already exists");
        UserEntity entity = UserEntity.builder()
                .email(registerRequest.getEmail())
                .phone(registerRequest.getPhone())
                .roles(Role.USER.name())
                .username(username)
                .fullName(registerRequest.getFullName())
                .status(1)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        return repository.save(entity);
    }
}
