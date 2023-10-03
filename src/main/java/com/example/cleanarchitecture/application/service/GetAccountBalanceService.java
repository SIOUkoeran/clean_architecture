package com.example.cleanarchitecture.application.service;

import com.example.cleanarchitecture.application.port.in.GetAccountBalanceQuery;
import com.example.cleanarchitecture.application.port.out.LoadAccountPort;
import com.example.cleanarchitecture.domain.Account;
import com.example.cleanarchitecture.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(Account.AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
                .calculateBalance();
    }
}
