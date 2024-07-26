package com.javaweb.api.admin;

import com.javaweb.model.dto.UserDTO;
import com.javaweb.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class UserAPI {
    private final IUserService service;

    @PostMapping
    public void addOrUpdate(@ModelAttribute UserDTO dto){
        service.addOrUpdate(dto);
    }

    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Integer> ids){
        service.delete(ids);
    }
}
