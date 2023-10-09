package com.example.cleanarchitecture.domain;

import lombok.*;
import java.time.LocalDateTime;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Account {
    @Getter private AccountId id;
    private Money baselineBalance;
    @Getter private ActivityWindow activityWindow;



    public Money calculateBalance() {
        return Money.add(
                this.baselineBalance,
                this.activityWindow.calculateBalance(this.id)
        );
    }

    public boolean withdraw(Money money, AccountId targetAccountId) {
        if (!mayWithdraw(money)) {
            return false;
        }
        Activity withdrwal = new Activity(
                this.id,
                this.id,
                targetAccountId,
                LocalDateTime.now(),
                money
        );
        this.activityWindow.addActivity(withdrwal);
        return true;
    }

    private boolean mayWithdraw(Money money) {
        return Money.add(
                this.calculateBalance(),
                money.negate()
        ).isPositive();
    }

    public boolean deposit(Money money, AccountId sourceAccountId) {
        var deposit = new Activity(
                this.id,
                sourceAccountId,
                this.id,
                LocalDateTime.now(),
                money
        );
        this.activityWindow.addActivity(deposit);
        return true;
    }


    @Value
    public static class AccountId {
        private Long value;
    }

    public static Account withId(
            AccountId accountId,
            Money baselineBalance,
            ActivityWindow activityWindow
    ){
      return new Account(
              accountId,
              baselineBalance,
              activityWindow
      );
    }
}
