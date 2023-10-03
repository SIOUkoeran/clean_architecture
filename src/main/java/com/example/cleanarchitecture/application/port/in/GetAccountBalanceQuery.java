package com.example.cleanarchitecture.application.port.in;

import com.example.cleanarchitecture.domain.Account;
import com.example.cleanarchitecture.domain.Money;
import org.springframework.stereotype.Service;

@Service
public interface GetAccountBalanceQuery {

    Money getAccountBalance(Account.AccountId accountId);
}
