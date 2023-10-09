package com.example.cleanarchitecture.account.adapter.out.persistence.repository;

import com.example.cleanarchitecture.account.adapter.out.persistence.AccountJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<AccountJpaEntity, Long> {
}
