package com.ArthurSilva.investAPI.InvestAPI.DTOs;

import com.ArthurSilva.investAPI.InvestAPI.Entities.Transaction;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TransactionDTO
{
    private long id;
    private String title;
    private String description;
    private String amount;
    private Instant date;

    public TransactionDTO(Transaction transaction)
    {
        this.id = transaction.getId();
        this.title = transaction.getTitle();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.date = transaction.getDate();
    }
}
