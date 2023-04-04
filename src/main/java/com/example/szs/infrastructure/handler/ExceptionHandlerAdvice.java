package com.example.szs.infrastructure.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = ConstraintViolationException.class)
    ResponseEntity<String> validationException(ConstraintViolationException ex) {
        log.error("ConstraintViolationException Message :: {}", ex.getMessage());
        return ResponseEntity.badRequest().body("입력값이 유효하지 않습니다.");
    }
}
