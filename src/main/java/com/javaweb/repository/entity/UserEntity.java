package com.javaweb.repository.entity;

import com.javaweb.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity implements UserDetails {
    private String username;

    private String password;

    @Column(name = "fullname")
    private String fullName;

    private String phone;

    private String email;

//    @Column(name = "dateofbirth")
//    private LocalDate dateOfBirth;

    private Integer status;

    @NotEmpty(message = "Chưa chọn chức năng cho tài khoản")
    private String roles;

    @ManyToMany(mappedBy = "users")
    private List<BuildingEntity> buildings = new ArrayList<>();

    @ManyToMany(mappedBy = "staffs")
    private List<CustomerEntity> customers = new ArrayList<>();

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(roles.split(",")).map(i -> new SimpleGrantedAuthority("ROLE_" + i)).toList();
    }
}