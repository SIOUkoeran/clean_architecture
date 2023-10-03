package com.example.cleanarchitecture.application.service;

import com.example.cleanarchitecture.application.port.in.SendMoneryUserCase;
import com.example.cleanarchitecture.application.port.in.SendMoneyCommand;
import com.example.cleanarchitecture.application.port.out.LoadAccountPort;
import com.example.cleanarchitecture.application.port.out.UpdateAccountStatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendMoneryService implements SendMoneryUserCase {

    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;
    private final UpdateAccountStatePort updateAccountStatePort;


    @Override
    public boolean sendMoney(SendMoneyCommand sendMoneyCommand) {
        // TODO : 비즈니스 규칙 검증
        // TODO : 모델 상태 조작
        // TODO : 출력 값 반환
    }
}
