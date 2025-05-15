package com.portfolio.bookclub.bookclub.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.bookclub.bookclub.persistance.entity.Club;

@Repository
public interface ClubRepo extends JpaRepository<Club, Long>{

}
