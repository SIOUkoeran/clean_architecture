package com.example.cleanarchitecture.application.service;

import com.example.cleanarchitecture.application.port.in.SendMoneryUseCase;
import com.example.cleanarchitecture.application.port.in.SendMoneyCommand;
import com.example.cleanarchitecture.application.port.out.AccountLock;
import com.example.cleanarchitecture.application.port.out.LoadAccountPort;
import com.example.cleanarchitecture.application.port.out.UpdateAccountStatePort;
import com.example.cleanarchitecture.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@UseCase
@Transactional
@RequiredArgsConstructor
public class SendMoneryService implements SendMoneryUseCase {

    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;
    private final UpdateAccountStatePort updateAccountStatePort;


    @Override
    public boolean sendMoney(SendMoneyCommand sendMoneyCommand) {
        // TODO : 비즈니스 규칙 검증
        // TODO : 모델 상태 조작
        // TODO : 출력 값 반환
        return true;
    }
}
