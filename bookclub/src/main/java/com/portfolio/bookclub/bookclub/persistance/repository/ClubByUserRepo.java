package com.portfolio.bookclub.bookclub.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.bookclub.bookclub.persistance.entity.ClubByUser;

@Repository
public interface ClubByUserRepo extends JpaRepository<ClubByUser, Long>{
    Optional<ClubByUser> findByUserIdAndClubId(Integer userId, Long clubId);
}
