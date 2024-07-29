package com.javaweb.model.dto;

import com.javaweb.repository.entity.TransactionEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class CustomerDTO extends AbstractDTO{
    private String name;
    private String phone;
    private String email;
    private String need;
    private String status;
    private Map<Pair<String, String>, List<TransactionEntity>> transactions = new HashMap<>();
}
