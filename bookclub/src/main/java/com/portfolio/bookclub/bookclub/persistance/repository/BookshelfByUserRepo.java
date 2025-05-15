package com.portfolio.bookclub.bookclub.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.bookclub.bookclub.persistance.entity.BookshelfByUser;

@Repository
public interface BookshelfByUserRepo extends JpaRepository<BookshelfByUser, Long>{

}
