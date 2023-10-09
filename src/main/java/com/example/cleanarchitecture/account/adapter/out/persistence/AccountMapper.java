package com.example.cleanarchitecture.account.adapter.out.persistence;

import com.example.cleanarchitecture.account.adapter.out.persistence.AccountJpaEntity;
import com.example.cleanarchitecture.account.adapter.out.persistence.ActivityJpaEntity;
import com.example.cleanarchitecture.domain.Account;
import com.example.cleanarchitecture.domain.Activity;
import com.example.cleanarchitecture.domain.ActivityWindow;
import com.example.cleanarchitecture.domain.Money;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {

    public Account mapToDomainEntity(
            AccountJpaEntity account,
            List<ActivityJpaEntity> activities,
            Long withdrwableBalance,
            Long depositBalance) {

        Money baselineBalance = Money.subtract(
                Money.of(withdrwableBalance),
                Money.of(depositBalance));
        return Account.withId(
                new Account.AccountId(account.getId()),
                baselineBalance,
                mapToActivityWindow(activities)
        );
    }

    ActivityWindow mapToActivityWindow(List<ActivityJpaEntity> activities) {
        ArrayList<Activity> mappedActivities = new ArrayList<>();

        for (ActivityJpaEntity activity : activities) {
            mappedActivities.add(new Activity(
                    new Activity.ActivityId(activity.getId()),
                    new Account.AccountId(activity.getOwnerAccountId()),
                    new Account.AccountId(activity.getSourceAccountId()),
                    new Account.AccountId(activity.getTargetAccountId()),
                    activity.getTimestamp(),
                    Money.of(activity.getAmount())
            ));
        }
        return new ActivityWindow(mappedActivities);
    }

    ActivityJpaEntity mapToJpaEntity(Activity activity) {
        return new ActivityJpaEntity(
                activity.getId() == null ? null : activity.getId().getValue(),
                activity.getTimestamp(),
                activity.getOwnerAccountId().getValue(),
                activity.getSourceAccountId().getValue(),
                activity.getTargetAccountId().getValue(),
                activity.getMoney().getAmount().longValue()
        );
    }
}
