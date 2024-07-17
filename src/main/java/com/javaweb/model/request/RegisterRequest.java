package com.javaweb.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@Builder
@AllArgsConstructor
public class RegisterRequest {
    private String fullName;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String retypePassword;
}
