package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserDTO extends AbstractDTO{
    private String fullName;
    private String username;
    private String email;
    private String phone;
    private String roles;
    private Integer status = 1;
//    private LocalDate dateOfBirth;
}
