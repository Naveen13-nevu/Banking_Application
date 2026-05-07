package com.banking.service.implementation;

import com.banking.dto.AccountDto;
import com.banking.mapper.AccountMapper;
import com.banking.model.Account;
import com.banking.repository.AccountRepository;
import com.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto){
       Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
    public AccountDto getAccountById(Long id){
      Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account id not exists"+ id));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById((id)).orElseThrow(()-> new RuntimeException("unable to find id"+ id));
        double total = account.getBalance()+amount;
        account.setBalance(total);
       Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }


}
