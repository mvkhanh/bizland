package com.javaweb.model.response;

public class BuildingSearchResponse {
    private Integer id;
    private String name;
    private String address;
    private Integer numberOfBasements;
    private String managerName;
    private String managerPhone;
    private Double floorArea;
    private Double leftArea;
    private Integer rentPrice;
    private Double serviceFee;
    private Double brokerageFee;
    private String rentAreas;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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
    public Double getLeftArea() {
        return leftArea;
    }
    public void setLeftArea(Double leftArea) {
        this.leftArea = leftArea;
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
    public Double getBrokerageFee() {
        return brokerageFee;
    }
    public void setBrokerageFee(Double brokerageFee) {
        this.brokerageFee = brokerageFee;
    }
    public String getRentAreas() {
        return rentAreas;
    }
    public void setRentAreas(String rentAreas) {
        this.rentAreas = rentAreas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}