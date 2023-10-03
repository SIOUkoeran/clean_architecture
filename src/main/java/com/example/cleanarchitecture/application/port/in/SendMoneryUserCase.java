package com.example.cleanarchitecture.application.port.in;

import org.springframework.stereotype.Service;

@Service
public interface SendMoneryUserCase{
    boolean sendMoney(SendMoneyCommand sendMoneyCommand);
}
