package com.javaweb.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@Builder
@AllArgsConstructor
public class RegisterRequest {
    @NotEmpty(message = "Tên đầy đủ không được để trống")
    private String fullName;

    @Email(message = "Email không đúng định dạng")
    @NotEmpty(message = "Email không được để trống")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Số điện thoại phải có đúng 10 chữ số")
    private String phone;

    @NotEmpty(message = "Tài khoản không được để trống")
    private String username;

    @NotEmpty(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự")
    private String password;
    private String retypePassword;
}
