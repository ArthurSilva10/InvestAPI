package com.ArthurSilva.investAPI.InvestAPI.DTOs;

import com.ArthurSilva.investAPI.InvestAPI.Entities.Transaction;
import com.ArthurSilva.investAPI.InvestAPI.Entities.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "username")
public class UserDTO
{
    private String username;
    private String fullName;
    private String CPF;
    private String email;
    private long phoneNumber;
    List<Transaction> transactions;

    public UserDTO(User user)
    {
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.CPF = user.getCPF();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.transactions = user.getTransactions();
    }
}
