package com.javaweb.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity{
    private String code;

    private String detail;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerEntity customer;
}
