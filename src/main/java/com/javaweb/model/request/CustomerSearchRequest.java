package com.javaweb.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSearchRequest extends BaseSearchRequest{
    private String phone;
    private String email;
    private String status;
    private Integer id_staff;
}
