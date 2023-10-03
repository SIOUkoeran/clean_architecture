package com.example.cleanarchitecture.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class ActivityWindow {

    private List<Activity> activities;

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public Money calculateBalance(Account.AccountId id) {
        return null;
    }
}
