package com.javaweb.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Getter
public enum CustomerStatus {
    CHUA_XU_LY("Chưa xử lý"),
    DANG_XU_LY("Đang xử lý"),
    DA_XU_LY("Đã xử lý");

    private final String value;

    CustomerStatus(String value) {
        this.value = value;
    }

    public static Map<String, String> getCustomerStatuses(){
        return Arrays.stream(CustomerStatus.values()).collect(Collectors.toMap(
                CustomerStatus::toString,
                CustomerStatus::getValue,
                (s, _) -> s,
                TreeMap::new
        ));
    }
}
