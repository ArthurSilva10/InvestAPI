package com.ArthurSilva.investAPI.InvestAPI.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "username")
public class User
{
    @Id
    @Column(unique = true)
    private String username;

    private String fullName;

    @Column(unique = true)
    private String CPF;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private long phoneNumber;

    @OneToMany
    @JoinColumn(name = "username")
    List<Transaction> transactions;
}
