package com.example.cleanarchitecture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class ActivityWindow {

    private List<Activity> activities;

    public ActivityWindow(Activity... activities) {
        for (Activity activity : activities) {
            addActivity(activity);
        }
    }

    public void addActivity(Activity activity) {
        if (this.activities == null)
            this.activities = new ArrayList<>();
        this.activities.add(activity);
    }

    public Money calculateBalance(Account.AccountId id) {
        Money depositBalance = activities.stream()
                .filter(a -> a.getTargetAccountId().equals(id))
                .map(Activity::getMoney)
                .reduce(Money.ZERO, Money::add);
        Money withdrawBalance = activities.stream()
                .filter(a -> a.getSourceAccountId().equals(id))
                .map(Activity::getMoney)
                .reduce(Money.ZERO, Money::add);
        return Money.add(depositBalance, withdrawBalance.negate());
    }

}
