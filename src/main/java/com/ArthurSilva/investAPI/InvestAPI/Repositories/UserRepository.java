package com.ArthurSilva.investAPI.InvestAPI.Repositories;

import com.ArthurSilva.investAPI.InvestAPI.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
}
