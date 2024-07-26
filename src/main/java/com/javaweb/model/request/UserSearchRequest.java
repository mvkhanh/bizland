package com.javaweb.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequest {
    private String fullName;
    private String phone;
    private String roles;
    private Integer pageNumber = 0, pageSize = 2, status = 1;
}
