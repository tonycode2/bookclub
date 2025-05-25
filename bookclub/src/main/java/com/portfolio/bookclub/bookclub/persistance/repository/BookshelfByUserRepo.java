package com.portfolio.bookclub.bookclub.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.bookclub.bookclub.persistance.entity.BookshelfByUser;

@Repository
public interface BookshelfByUserRepo extends JpaRepository<BookshelfByUser, Long>{
    List<BookshelfByUser> findByUserId(Integer id);
}
