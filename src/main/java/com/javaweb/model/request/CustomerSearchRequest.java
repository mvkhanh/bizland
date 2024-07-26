package com.javaweb.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSearchRequest {
    private String name;
    private String phone;
    private String email;
    private String status;
    private Integer id_staff;
    private Integer pageNumber = 0, pageSize = 2;
}
