package com.example.szs.infrastructure.interceptor.web;

import com.example.szs.common.utils.RequestUtils;
import com.example.szs.infrastructure.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<String> opToken = RequestUtils.parseAuthHeaderValue(request);

        if (opToken.isPresent()) {
            String userId = jwtProvider.parseUserIdByToken(opToken.get());
            log.info("userID :: {}", userId);
        }

        log.info("in interceptor !!!");

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
