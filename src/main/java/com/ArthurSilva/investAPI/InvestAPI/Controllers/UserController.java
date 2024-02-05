package com.ArthurSilva.investAPI.InvestAPI.Controllers;

import com.ArthurSilva.investAPI.InvestAPI.DTOs.UserDTO;
import com.ArthurSilva.investAPI.InvestAPI.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService service;

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAll()
    {
        List<UserDTO> lista = service.findAllUsers();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String userName)
    {
        UserDTO data = service.findUser(userName);
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public ResponseEntity<UserDTO> setUser(@RequestBody UserDTO dto)
    {
        UserDTO data = service.addUser(dto);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/{userName}/{id}")
    public ResponseEntity<UserDTO> addTransactionToList(@PathVariable String userName, @PathVariable long id)
    {
        UserDTO data = service.addTransactionToList(userName, id);
        return ResponseEntity.ok(data);
    }
}
