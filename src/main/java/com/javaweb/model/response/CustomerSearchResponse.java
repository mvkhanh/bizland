package com.javaweb.model.response;

import com.javaweb.enums.CustomerStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerSearchResponse {
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String status;
}
