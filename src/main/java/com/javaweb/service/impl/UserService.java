package com.javaweb.service.impl;

import com.javaweb.converter.UserConverter;
import com.javaweb.enums.Role;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.request.UserSearchRequest;
import com.javaweb.repository.IUserRepository;
import com.javaweb.repository.entity.UserEntity;
import com.javaweb.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter converter;
//    private final JwtUtil jwtUtil;
//    private final AuthenticationManager authenticationManager;

    @Override
    public Page<UserDTO> findAll(UserSearchRequest search) {
        Pageable pageable = PageRequest.of(search.getPageNumber(), search.getPageSize());
        UserEntity userProbe = UserEntity.builder()
                        .fullName(StringUtils.hasText(search.getFullName()) ? search.getFullName() : null)
                        .roles(StringUtils.hasText(search.getRoles()) ? search.getRoles() : null)
                        .phone(StringUtils.hasText(search.getPhone()) ? search.getPhone() : null)
                        .status(1)
                        .build();
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                        .withMatcher("fullName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("roles", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("phone", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<UserEntity> example = Example.of(userProbe, matcher);
        return repository.findAll(example, pageable).map(i -> {
            i.setRoles(Role.valueOf(i.getRoles()).getName());
            return converter.EntityToDTO(i);
        });
    }

    @Override
    public Map<Integer, String> findAllStaff() {
        return repository.findAllByStatusAndRolesContaining(1, Role.STAFF.name()).stream()
            .collect(Collectors.toMap(
                    UserEntity::getId,
                    UserEntity::getFullName
            ));
    }

    @Override
    public UserDTO findById(Integer id) {
        return converter.EntityToDTO(repository.findById(id).get());
    }

    @Override
    public void addOrUpdate(UserDTO dto) {
        UserEntity entity = converter.DTOToEntity(dto);
        if(dto.getId() != null){
            UserEntity existUser = repository.findById(dto.getId()).get();
            entity.setCustomers(existUser.getCustomers());
            entity.setBuildings(existUser.getBuildings());
            entity.setPassword(existUser.getPassword());
        }
        else entity.setPassword(passwordEncoder.encode("123456"));
//        else entity.setPassword(passwordEncoder.encode(PasswordGenerator.generateRandomPassword(6)));
//        Gui ve email hoac so dien thoai
//        Dung tai khoan la email hoac sdt luon
        repository.save(entity);
    }

    @Override
    public void delete(List<Integer> ids) {
        repository.findAllById(ids).forEach(user -> {
            user.setStatus(0);
            repository.save(user);
        });
    }
}
