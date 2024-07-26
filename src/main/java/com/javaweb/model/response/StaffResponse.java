package com.javaweb.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class StaffResponse {
    private Integer id;
    private String fullName;
    private String checked;
}
