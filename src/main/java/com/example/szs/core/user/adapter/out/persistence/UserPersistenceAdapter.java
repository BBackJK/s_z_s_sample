package com.example.szs.core.user.adapter.out.persistence;


import com.example.szs.core.user.application.port.out.RegisterUserPort;
import com.example.szs.core.user.domain.User;
import com.example.szs.infrastructure.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@PersistenceAdapter
@RequiredArgsConstructor
@Slf4j
class UserPersistenceAdapter implements RegisterUserPort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapHelper userMapHelper;

    @Override
    public void register(User user) {
        if (userJpaRepository.findById(user.getUserId()).isPresent()) throw new RuntimeException("아이디 중복"); // TODO: Custom Exception 처리

        userJpaRepository.save(
                userMapHelper.toEntity(user)
        );
    }
}
