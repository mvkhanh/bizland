package com.javaweb.model.dto;

import com.javaweb.repository.entity.RentAreaEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
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

}