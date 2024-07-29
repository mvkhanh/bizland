package com.javaweb.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
}