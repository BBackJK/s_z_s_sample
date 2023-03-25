package com.example.szs.core.scrap.adapter.out.persistence.repositories;

import com.example.szs.core.scrap.adapter.out.persistence.entity.UserIncomeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserIncomeRepository extends JpaRepository<UserIncomeJpaEntity, Long> {

    List<UserIncomeJpaEntity> findByUserIdAndUseYn(String userId, boolean useYn);
}
