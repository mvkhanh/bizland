package com.javaweb.enums;

import java.util.*;
import java.util.stream.Collectors;

public enum District {
    QUAN_1("Quận 1"),
    QUAN_2("Quận 2"),
    QUAN_3("Quận 3"),
    QUAN_10("Quận 10"),
    QUAN_THU_DUC("Quận Thủ Đức");

    private final String name;

    District(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Map<String, String> getDistricts(){
        return Arrays.stream(District.values()).collect(Collectors.toMap(
                District::toString,
                District::getName,
                (s, _) -> s,
                TreeMap::new
        ));
    }
}
