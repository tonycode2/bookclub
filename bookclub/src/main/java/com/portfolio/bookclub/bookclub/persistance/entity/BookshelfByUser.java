package com.portfolio.bookclub.bookclub.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "bookshelf_by_user")
@Entity
@NoArgsConstructor
public class BookshelfByUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @Column(name = "book_id", nullable = false)
    String bookId;
    @Column(name = "is_completed", nullable = false)
    Boolean isCompleted;
    @Column(name = "is_started", nullable = false)
    Boolean isStarted;

}
