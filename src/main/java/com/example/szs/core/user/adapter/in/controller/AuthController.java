package com.example.szs.core.user.adapter.in.controller;

import com.example.szs.core.user.adapter.in.controller.model.UserSignUpRequestDto;
import com.example.szs.core.user.application.port.in.RegisterUserCommand;
import com.example.szs.core.user.application.port.in.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping(value = "/szs/signup")
    String signup(@RequestBody UserSignUpRequestDto payload) {

        registerUserUseCase.register(RegisterUserCommand.of(
                payload.getUserId()
                , payload.getPassword()
                , payload.getName()
                , payload.getRegNo()
        ));

        return "OK";
    }
}
