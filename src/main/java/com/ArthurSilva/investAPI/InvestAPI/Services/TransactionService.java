package com.ArthurSilva.investAPI.InvestAPI.Services;

import com.ArthurSilva.investAPI.InvestAPI.DTOs.TransactionDTO;
import com.ArthurSilva.investAPI.InvestAPI.Entities.Transaction;
import com.ArthurSilva.investAPI.InvestAPI.ExeptionHandler.Exeptions.ResourceNotFoundExeption;
import com.ArthurSilva.investAPI.InvestAPI.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService
{
    @Autowired
    TransactionRepository repository;

    public List<TransactionDTO> findAll()
    {
        List<Transaction> list = repository.findAll();
        return list.stream().map(transaction -> new TransactionDTO(transaction)).collect(Collectors.toList());
    }

    public TransactionDTO findTransaction(long id)
    {
        Optional<Transaction> obj = repository.findById(id);
        Transaction transaction = obj.orElseThrow(() -> new ResourceNotFoundExeption("Resouce not found"));
        return new TransactionDTO(transaction);
    }

    public TransactionDTO addTransaction(TransactionDTO dto)
    {
        Transaction transaction = new Transaction();
        transaction.setTitle(dto.getTitle());
        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(Instant.now());
        transaction = repository.save(transaction);
        return new TransactionDTO(transaction);
    }
}
