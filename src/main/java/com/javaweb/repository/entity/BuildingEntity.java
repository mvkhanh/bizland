package com.javaweb.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity{
    private String name;

    private String street;

    private String ward;

    private String district;

    private String direction;

    private Integer level;

    @Column(name = "numberofbasements")
    private Integer numberOfBasements;

    @Column(name = "managername")
    private String managerName;

    @Column(name = "managerphone")
    private String managerPhone;

    @Column(name = "rentprice")
    private Integer rentPrice;

    @Column(name = "rentpricedescription")
    private String rentPriceDescription;

    private String struct;

    @Column(name = "rentalterm")
    private String rentalTerm;

    @Column(name = "decorationtime")
    private String decorationTime;

    private String note;

    @Column(name = "floorarea")
    private Double floorArea;

    @Column(name = "servicefee")
    private Double serviceFee;

    private Double deposit;

    @Column(name = "carfee")
    private Double carFee;

    @Column(name = "motorfee")
    private Double motorFee;

    @Column(name = "overtimefee")
    private Double overtimeFee;

    @Column(name = "electricbill")
    private Double electricBill;

    private Double payment;

    @Column(name = "brokeragefee")
    private Double brokerageFee;

    @Column(name = "typecodes")
    private String typeCodes;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] image;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentAreaEntity> rentAreas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "buildingassignment", joinColumns = @JoinColumn(name = "id_building"), inverseJoinColumns = @JoinColumn(name = "id_staff"))
    private List<UserEntity> staffs = new ArrayList<>();
}
