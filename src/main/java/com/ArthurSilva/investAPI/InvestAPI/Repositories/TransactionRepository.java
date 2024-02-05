package com.ArthurSilva.investAPI.InvestAPI.Repositories;

import com.ArthurSilva.investAPI.InvestAPI.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>
{
}
