package com.javaweb.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequest extends BaseSearchRequest{
    private String fullName;
    private String phone;
    private String roles;
}
