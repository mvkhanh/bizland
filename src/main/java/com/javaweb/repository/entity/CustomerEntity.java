package com.javaweb.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {
    private String name;

    @Column(name = "phone")
    private String phone;

    private String email;

    private String need;

    private String note;

    private String status;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionEntity> transactions = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "customerassignment", joinColumns = @JoinColumn(name = "id_customer"), inverseJoinColumns = @JoinColumn(name = "id_staff"))
    private List<UserEntity> staffs = new ArrayList<>();
}
