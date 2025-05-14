package com.portfolio.bookclub.bookclub.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.bookclub.bookclub.persistance.entity.VerificationToken;


public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long>{
    Optional<VerificationToken> findByToken(String token);
    void deleteByUserId(Integer userId);
}
