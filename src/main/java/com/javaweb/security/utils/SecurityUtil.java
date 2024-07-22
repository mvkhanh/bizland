package com.javaweb.security.utils;

import com.javaweb.repository.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityUtil {
    public static UserEntity getUserDetail(){
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static List<String> getRoles(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(i -> i.getAuthority().substring(5)).toList();
    }
}
