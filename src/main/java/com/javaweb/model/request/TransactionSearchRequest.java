package com.javaweb.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionSearchRequest extends BaseSearchRequest{
    private Integer id_customer;
    private String code;
}
