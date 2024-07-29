package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO extends AbstractDTO{
    private String code;
    private String detail;
    private Integer customerId;
}
