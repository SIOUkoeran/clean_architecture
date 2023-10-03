package com.example.cleanarchitecture.application.port.in;

import com.example.cleanarchitecture.common.SelfValidating;
import com.example.cleanarchitecture.domain.Account;
import com.example.cleanarchitecture.domain.Account.AccountId;
import com.example.cleanarchitecture.domain.Money;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    @NotNull
    private final AccountId sourceAccountId;
    @NotNull
    private final AccountId targetAccountId;
    @NotNull
    private final Money money;

    public SendMoneyCommand(AccountId sourceAccountId, AccountId targetAccountId, Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.validateSelf();
    }
}
