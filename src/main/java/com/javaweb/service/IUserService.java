package com.javaweb.service;

import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.request.UserSearchRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface IUserService {
    Page<UserDTO> findAll(UserSearchRequest search);
    Map<Integer, String> findAllStaff();

    UserDTO findById(Integer id);

    void addOrUpdate(UserDTO dto);

    void delete(List<Integer> ids);
}
