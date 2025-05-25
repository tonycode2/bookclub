package com.portfolio.bookclub.bookclub.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.bookclub.bookclub.persistance.entity.Club;

@Repository
public interface ClubRepo extends JpaRepository<Club, Long>{
    Optional<Club> findByUserId(Integer userId);

}
