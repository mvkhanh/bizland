package com.javaweb.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentAreaEntity> rentAreas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "buildingassignment", joinColumns = @JoinColumn(name = "id_building"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<UserEntity> users = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getWard() {
        return ward;
    }
    public void setWard(String ward) {
        this.ward = ward;
    }
    public Integer getNumberOfBasements() {
        return numberOfBasements;
    }
    public void setNumberOfBasements(Integer numberOfBasements) {
        this.numberOfBasements = numberOfBasements;
    }
    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public String getManagerPhone() {
        return managerPhone;
    }
    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }
    public Double getFloorArea() {
        return floorArea;
    }
    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }
    public Integer getRentPrice() {
        return rentPrice;
    }
    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }
    public Double getServiceFee() {
        return serviceFee;
    }
    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }
    public Double getDeposit() {
        return deposit;
    }
    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }
    public String getRentPriceDescription() {
        return rentPriceDescription;
    }
    public void setRentPriceDescription(String rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }
    public String getStruct() {
        return struct;
    }
    public void setStruct(String struct) {
        this.struct = struct;
    }
    public String getRentalTerm() {
        return rentalTerm;
    }
    public void setRentalTerm(String rentalTerm) {
        this.rentalTerm = rentalTerm;
    }
    public String getDecorationTime() {
        return decorationTime;
    }
    public void setDecorationTime(String decorationTime) {
        this.decorationTime = decorationTime;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Double getCarFee() {
        return carFee;
    }
    public void setCarFee(Double carFee) {
        this.carFee = carFee;
    }
    public Double getMotorFee() {
        return motorFee;
    }
    public void setMotorFee(Double motorFee) {
        this.motorFee = motorFee;
    }
    public Double getOvertimeFee() {
        return overtimeFee;
    }
    public void setOvertimeFee(Double overtimeFee) {
        this.overtimeFee = overtimeFee;
    }
    public Double getElectricBill() {
        return electricBill;
    }
    public void setElectricBill(Double electricBill) {
        this.electricBill = electricBill;
    }
    public Double getPayment() {
        return payment;
    }
    public void setPayment(Double payment) {
        this.payment = payment;
    }
    public List<RentAreaEntity> getRentAreas() {
        return rentAreas;
    }
    public void setRentAreas(List<RentAreaEntity> rentAreas) {
        this.rentAreas = rentAreas;
    }
    public List<UserEntity> getUsers() {
        return users;
    }
    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Double getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(Double brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTypeCodes() {
        return typeCodes;
    }

    public void setTypeCodes(String typeCodes) {
        this.typeCodes = typeCodes;
    }
}
