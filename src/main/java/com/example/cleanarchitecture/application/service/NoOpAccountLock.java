package com.example.cleanarchitecture.application.service;

import com.example.cleanarchitecture.application.port.out.AccountLock;
import com.example.cleanarchitecture.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class NoOpAccountLock implements AccountLock {
    @Override
    public void lockAccount(Account.AccountId accountId) {

    }

    @Override
    public void releaseAccount(Account.AccountId accountId) {

    }
}
