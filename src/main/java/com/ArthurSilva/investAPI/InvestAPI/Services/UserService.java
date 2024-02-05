package com.ArthurSilva.investAPI.InvestAPI.Services;

import com.ArthurSilva.investAPI.InvestAPI.DTOs.UserDTO;
import com.ArthurSilva.investAPI.InvestAPI.Entities.Transaction;
import com.ArthurSilva.investAPI.InvestAPI.Entities.User;
import com.ArthurSilva.investAPI.InvestAPI.ExeptionHandler.Exeptions.ResourceNotFoundExeption;
import com.ArthurSilva.investAPI.InvestAPI.Repositories.TransactionRepository;
import com.ArthurSilva.investAPI.InvestAPI.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService
{
    @Autowired
    UserRepository repository;
    @Autowired
    TransactionRepository transactionRepository;

    public List<UserDTO> findAllUsers()
    {
        List<User> list = repository.findAll();
        return list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }

    public UserDTO findUser(String username)
    {
        Optional<User> obj = repository.findById(username);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundExeption("User not found"));
        return new UserDTO(entity);
    }

    public UserDTO addUser(UserDTO dto)
    {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setCPF(dto.getCPF());
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setTransactions(dto.getTransactions());
        user = repository.save(user);
        return new UserDTO(user);
    }

    public UserDTO addTransactionToList(String username, long id)
    {
        Optional<User> user = repository.findById(username);
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if(transaction != null)
        {
            user.get().getTransactions().add(transaction.get());
            repository.save(user.get());
        }
        return new UserDTO(user.get());
    }
}
