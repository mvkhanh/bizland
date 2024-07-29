package com.javaweb.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseSearchRequest {
    private String name;
    private Integer pageNumber = 0, pageSize = 2;
    private Boolean deleted = false;
    private String sortColumn = "id", sortDirection = "asc";
}
