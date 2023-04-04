package com.example.szs.core.user.application.service;

import com.example.szs.core.user.application.port.in.RegisterUserCommand;
import com.example.szs.core.user.application.port.in.RegisterUserUseCase;
import com.example.szs.core.user.application.port.out.RegisterUserPort;
import com.example.szs.core.user.domain.User;
import com.example.szs.infrastructure.encrypt.PasswordEncryptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRegisterService implements RegisterUserUseCase {
    private final RegisterUserPort registerUserPort;
    private final PasswordEncryptor passwordEncryptor;
    @Override
    public void register(RegisterUserCommand command) {
        log.info("{}", command);
        registerUserPort.register(
                User.of(
                        command.getUserId()
                        , command.getName()
                        , passwordEncryptor.hash(command.getPassword())
                        , command.getRegNo()
                )
        );
    }


}
