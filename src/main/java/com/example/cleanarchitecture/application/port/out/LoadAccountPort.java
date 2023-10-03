package com.example.cleanarchitecture.application.port.out;

import com.example.cleanarchitecture.domain.Account;
import com.example.cleanarchitecture.domain.Account.AccountId;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public interface LoadAccountPort {
    public Account loadAccount(AccountId accountId, LocalDateTime now);
}
