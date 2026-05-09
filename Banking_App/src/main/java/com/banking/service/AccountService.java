package com.banking.service;

import com.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto account);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
    List<AccountDto> getAllaccounts();
    void deleteAccount(Long id);
}
