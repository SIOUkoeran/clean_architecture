package com.example.cleanarchitecture.application.port.in;

import com.example.cleanarchitecture.common.UseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


public interface SendMoneryUseCase {
    boolean sendMoney(SendMoneyCommand sendMoneyCommand);
}
