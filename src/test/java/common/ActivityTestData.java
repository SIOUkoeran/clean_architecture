package common;

import com.example.cleanarchitecture.domain.Account;
import com.example.cleanarchitecture.domain.Account.AccountId;
import com.example.cleanarchitecture.domain.Activity;
import com.example.cleanarchitecture.domain.Activity.ActivityId;
import com.example.cleanarchitecture.domain.Money;

import java.time.LocalDateTime;

public class ActivityTestData {

    public static ActivityBuilder defaultActivity() {
        return new ActivityBuilder()
                .withId(new ActivityId(1L))
                .withOwnerAccountId(new AccountId(42L))
                .withSourceAccountId(new AccountId(42L))
                .withTargetAccount(new AccountId(41L))
                .withTimestamp(LocalDateTime.now())
                .withMoney(Money.of(999L));
    }


    public static class ActivityBuilder {
        private ActivityId id;
        private AccountId ownerAccountId;
        private AccountId sourceAccountId;
        private AccountId targetAccountId;
        private LocalDateTime timestamp;
        private Money money;

        public ActivityBuilder withId(ActivityId activityId){
            this.id = activityId;
            return this;
        }

        public ActivityBuilder withOwnerAccountId(AccountId ownerAccountId){
            this.ownerAccountId = ownerAccountId;
            return this;
        }
        public ActivityBuilder withSourceAccountId(AccountId sourceAccountId){
            this.sourceAccountId = sourceAccountId;
            return this;
        }

        public ActivityBuilder withTargetAccount(AccountId withTargetAccount){
            this.targetAccountId = withTargetAccount;
            return this;
        }

        public ActivityBuilder withTimestamp(LocalDateTime timestamp){
            this.timestamp = timestamp;
            return this;
        }

        public ActivityBuilder withMoney(Money money) {
            this.money = money;
            return this;
        }

        public Activity build() {
            return  new Activity(
                    this.id,
                    this.ownerAccountId,
                    this.sourceAccountId,
                    this.targetAccountId,
                    this.timestamp,
                    this.money
            );
        }
    }
}
