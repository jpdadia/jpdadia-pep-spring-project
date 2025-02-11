package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public Account createAccount(Account acc){
        return accountRepository.save(acc);
    }
    
    public Optional<Account> findByUsername(String username){
        return accountRepository.findByUsername(username);
    }

    public Optional<Account> authenticateUser(String username, String password){
        return accountRepository.findByUsernameAndPassword(username, password);
    }

    public boolean existsById (Integer id){
        return accountRepository.existsById(id);
    }
}
