package com.example.cleanarchitecture.account.adapter.out.persistence;

import com.example.cleanarchitecture.account.adapter.out.persistence.repository.AccountRepository;
import com.example.cleanarchitecture.account.adapter.out.persistence.repository.ActivityRepository;
import com.example.cleanarchitecture.application.port.out.LoadAccountPort;
import com.example.cleanarchitecture.application.port.out.UpdateAccountStatePort;
import com.example.cleanarchitecture.common.PersistenceAdapter;
import com.example.cleanarchitecture.domain.Account;
import com.example.cleanarchitecture.domain.Activity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {

    private final AccountRepository accountRepository;
    private final ActivityRepository activityRepository;
    private final AccountMapper accountMapper;
    @Override
    public Account loadAccount(Account.AccountId accountId, LocalDateTime now) {

        AccountJpaEntity account = accountRepository.findById(accountId.getValue())
                .orElseThrow(EntityNotFoundException::new);

        List<ActivityJpaEntity> activities
                = activityRepository.findAllByOwnerAccountIdAfterAndTimestamp(
                accountId.getValue(),
                now);

        Long withdrwableBalance
                = orZero(activityRepository.getWithdrawBalanceUntil(
                accountId.getValue(),
                now
        ));

        Long depositBalance
                = orZero(activityRepository.getDepositBalanceUntil(
                accountId.getValue(),
                now
        ));

        return accountMapper.mapToDomainEntity(
                account,
                activities,
                withdrwableBalance,
                depositBalance
        );
    }

    private Long orZero(Long value) {
        return value == null ? 0L : value;
    }

    @Override
    public void updateActivities(Account account) {
        for (Activity activity : account.getActivityWindow().getActivities()) {
            if (activity.getId() == null) {
                activityRepository.save(accountMapper.mapToJpaEntity(activity));
            }
        }
    }
}
