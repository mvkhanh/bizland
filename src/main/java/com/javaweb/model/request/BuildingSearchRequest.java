package com.javaweb.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class BuildingSearchRequest extends BaseSearchRequest{
    private String ward, street, direction, managerPhone, managerName, district;
    private Integer numberOfBasements, areaTo, areaFrom, level, id_staff;
    private Double floorArea, rentPriceTo, rentPriceFrom;
    private List<String> typeCodes = new ArrayList<>();

}
