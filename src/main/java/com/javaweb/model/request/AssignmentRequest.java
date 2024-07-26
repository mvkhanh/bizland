package com.javaweb.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AssignmentRequest {
    private Integer id;
    private List<Integer> staffIds;
}
