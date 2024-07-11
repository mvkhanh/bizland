package com.javaweb.model.dto;

import com.javaweb.repository.entity.RentAreaEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class BuildingDTO extends AbstractDTO{
    private String name;
    private String street;
    private String ward;
    private String district;
    private Integer numberOfBasements;
    private String managerName;
    private String managerPhone;
    private Double floorArea;
    private Integer rentPrice;
    private String rentPriceDescription;
    private String struct;
    private String direction;
    private Integer level;
    private String rentalTerm;
    private String decorationTime;
    private Double serviceFee;
    private Double carFee;
    private Double motorFee;
    private Double overtimeFee;
    private Double electricBill;
    private Double deposit;
    private Double payment;
    private Double brokerageFee;
    private String rentAreas;
    private String note;
    private List<String> typeCodes = new ArrayList<>();
    private MultipartFile imageFile;

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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
    public Double getServiceFee() {
        return serviceFee;
    }
    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
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
    public Double getDeposit() {
        return deposit;
    }
    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }
    public Double getPayment() {
        return payment;
    }
    public void setPayment(Double payment) {
        this.payment = payment;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
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

    public Double getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(Double brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public List<String> getTypeCodes() {
        return typeCodes;
    }

    public void setTypeCodes(List<String> typeCodes) {
        this.typeCodes = typeCodes;
    }

    public String getRentAreas() {
        return rentAreas;
    }

    public void setRentAreas(String rentAreas) {
        this.rentAreas = rentAreas;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}