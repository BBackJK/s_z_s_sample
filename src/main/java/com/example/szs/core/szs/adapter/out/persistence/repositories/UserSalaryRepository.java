package com.example.szs.core.szs.adapter.out.persistence.repositories;

import com.example.szs.core.szs.adapter.out.persistence.entity.UserSalaryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSalaryRepository extends JpaRepository<UserSalaryJpaEntity, Long> {

    List<UserSalaryJpaEntity> findByUserIdAndUseYn(String userId, boolean useYn);
}
