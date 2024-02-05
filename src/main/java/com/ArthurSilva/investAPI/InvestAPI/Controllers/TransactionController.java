package com.ArthurSilva.investAPI.InvestAPI.Controllers;

import com.ArthurSilva.investAPI.InvestAPI.DTOs.TransactionDTO;
import com.ArthurSilva.investAPI.InvestAPI.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController
{
    @Autowired
    TransactionService service;

    @GetMapping("/")
    public ResponseEntity<List<TransactionDTO>> findAll()
    {
        List<TransactionDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> findById(@PathVariable Long id)
    {
        TransactionDTO dto = service.findTransaction(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> addUser(@RequestBody TransactionDTO dto)
    {
        TransactionDTO data = service.addTransaction(dto);
        return ResponseEntity.ok(data);
    }
}
