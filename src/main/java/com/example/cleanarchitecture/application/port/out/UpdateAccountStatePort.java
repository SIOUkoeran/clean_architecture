package com.example.cleanarchitecture.application.port.out;

import com.example.cleanarchitecture.domain.Account;
import org.springframework.stereotype.Component;

@Component
public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}
