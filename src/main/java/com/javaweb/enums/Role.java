package com.javaweb.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Getter
public enum Role {
    ADMIN("Quản trị viên"),
    USER("Người dùng"),
    STAFF("Nhân viên"),
    MANAGER("Quản lý");

    private final String name;

    Role(String name){
        this.name = name;
    }

    public static Map<String, String> getRoles(){
        return Arrays.stream(Role.values()).collect(Collectors.toMap(
                Role::toString,
                Role::getName,
                (s, _) -> s,
                TreeMap::new
        ));
    }
}
