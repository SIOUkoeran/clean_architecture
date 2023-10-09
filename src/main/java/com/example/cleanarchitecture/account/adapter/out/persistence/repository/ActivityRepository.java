package com.example.cleanarchitecture.account.adapter.out.persistence.repository;

import com.example.cleanarchitecture.account.adapter.out.persistence.ActivityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityJpaEntity, Long> {

    List<ActivityJpaEntity> findAllByOwnerAccountIdAfterAndTimestamp(Long accountId, LocalDateTime now);


    @Query("select a from ActivityJpaEntity  a " +
            "where a.ownerAccountId = :ownerAccountId " +
            "and a.timestamp >= :since")
    List<ActivityJpaEntity> findByOwnerSince(
            @Param("ownerAccountId") Long ownerAccountId,
            @Param("since") LocalDateTime since
    );

    @Query("select sum(a.amount) from ActivityJpaEntity  a " +
            "where a.targetAccountId = :accountId " +
            "and a.ownerAccountId =: accountId " +
            "and a.timestamp < :until")
    Long getDepositBalanceUntil(
            @Param("accountId") Long accountId,
            @Param("until")LocalDateTime until);

    @Query("select sum(a.amount) from ActivityJpaEntity a " +
            "where a.sourceAccountId = :accountId " +
            "and a.ownerAccountId = :accountId " +
            "and a.timestamp < :until")
    Long getWithdrawBalanceUntil(
            @Param("accountId") Long accountId,
            @Param("until") LocalDateTime until);
}
