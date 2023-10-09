package com.example.cleanarchitecture;

import com.example.cleanarchitecture.domain.Account;
import com.example.cleanarchitecture.domain.Account.AccountId;
import com.example.cleanarchitecture.domain.ActivityWindow;
import com.example.cleanarchitecture.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static common.AccountTestData.defaultAccount;
import static common.ActivityTestData.defaultActivity;

public class AccountTest {
    @Test
    void withdrawalSucceeds() {
        AccountId accountId = new AccountId(1L);
        Account account = defaultAccount()
                .withAccountId(accountId)
                .withBaselineBalance(Money.of(555L))
                .withActivityWindow(new ActivityWindow(
                        defaultActivity()
                                .withTargetAccount(accountId)
                                .withMoney(Money.of(999L)).build(),
                        defaultActivity()
                                .withTargetAccount(accountId)
                                .withMoney(Money.of(1L)).build()))
                .build();

        boolean withdraw = account.withdraw(Money.of(555L), new AccountId(99L));

        Assertions.assertThat(withdraw).isTrue();

    }




}
