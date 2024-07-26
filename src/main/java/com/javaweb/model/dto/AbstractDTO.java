package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public abstract class AbstractDTO {
    private Integer id;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
