package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Setter
@Getter
public abstract class AbstractDTO {
    private Integer id;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
