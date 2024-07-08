package com.javaweb.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public enum TypeCode {
    NOI_THAT("Nội thất"),
    NGUYEN_CAN("Nguyên căn"),
    TANG_TRET("Tầng trệt");

    private final String name;

    TypeCode(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Map<String, String> getTypecodes(){
        return Arrays.stream(TypeCode.values()).collect(Collectors.toMap(
                TypeCode::toString,
                TypeCode::getName,
                (s, _) -> s,
                TreeMap::new
        ));
    }
}
