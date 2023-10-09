package com.example.cleanarchitecture.application.port.out;

import com.example.cleanarchitecture.domain.Account;

public interface AccountLock {
    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);
}
