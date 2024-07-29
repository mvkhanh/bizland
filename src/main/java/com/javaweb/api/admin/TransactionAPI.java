package com.javaweb.api.admin;

import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/transactions")
@RequiredArgsConstructor
public class TransactionAPI {
    private final ITransactionService service;

    @PostMapping
    public void addOrUpdate(@RequestBody TransactionDTO transaction) {
        service.addOrUpdate(transaction);
    }

    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Integer> ids){
        service.delete(ids);
    }
}
