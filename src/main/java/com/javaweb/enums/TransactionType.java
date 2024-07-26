package com.javaweb.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Getter
public enum TransactionType {
    CSKH("Chăm sóc khách hàng"),
    DDX("Dẫn đi xem");

    private final String name;

    TransactionType(String name){
        this.name = name;
    }

    public static Map<String, String> getTransactionTypes(){
        return Arrays.stream(TransactionType.values()).collect(Collectors.toMap(
                TransactionType::toString,
                TransactionType::getName,
                (s, _) -> s,
                TreeMap::new
        ));
    }
}
