package com.example.szs.core.szs.adapter.out.persistence.repositories;

import com.example.szs.core.szs.adapter.out.persistence.entity.UserOutputTaxJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserOutputTaxRepository extends JpaRepository<UserOutputTaxJpaEntity, Long> {

    UserOutputTaxJpaEntity findByUserIdAndUseYn(String userId, boolean useYn);
}
