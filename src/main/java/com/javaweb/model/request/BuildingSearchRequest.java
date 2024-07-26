package com.javaweb.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class BuildingSearchRequest {
    private String name, ward, street, direction, managerPhone, managerName, district;
    private Integer numberOfBasements, areaTo, areaFrom, level, id_staff;
    private Double floorArea, rentPriceTo, rentPriceFrom;
    private Integer pageNumber = 0, pageSize = 5;
    private List<String> typeCodes = new ArrayList<>();

}
