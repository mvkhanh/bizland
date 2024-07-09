package com.javaweb.model.request;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchRequest {
    private String name, ward, street, direction, managerPhone, managerName, district;
    private Integer numberOfBasements, areaTo, areaFrom, level, id_staff;
    private Double floorArea, rentPriceTo, rentPriceFrom;
    private  Integer pageNumber = 0, pageSize = 2;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    private List<String> typeCodes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }

    public Double getRentPriceTo() {
        return rentPriceTo;
    }

    public void setRentPriceTo(Double rentPriceTo) {
        this.rentPriceTo = rentPriceTo;
    }

    public Double getRentPriceFrom() {
        return rentPriceFrom;
    }

    public void setRentPriceFrom(Double rentPriceFrom) {
        this.rentPriceFrom = rentPriceFrom;
    }

    public Integer getNumberOfBasements() {
        return numberOfBasements;
    }

    public void setNumberOfBasements(Integer numberOfBasements) {
        this.numberOfBasements = numberOfBasements;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getAreaTo() {
        return areaTo;
    }

    public void setAreaTo(Integer areaTo) {
        this.areaTo = areaTo;
    }

    public Integer getAreaFrom() {
        return areaFrom;
    }

    public void setAreaFrom(Integer areaFrom) {
        this.areaFrom = areaFrom;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getId_staff() {
        return id_staff;
    }

    public void setId_staff(Integer id_staff) {
        this.id_staff = id_staff;
    }

    public List<String> getTypeCodes() {
        return typeCodes;
    }

    public void setTypeCodes(List<String> typeCodes) {
        this.typeCodes = typeCodes;
    }
}
