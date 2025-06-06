package com.portfolio.bookclub.bookclub.persistance.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Table(name = "review")
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @Column(name = "book_id", nullable = false)
    String bookId;
    @Min(1)
    @Max(5)
    @Column(nullable = false)
    Integer rating;
    @Column(length = 1000)
    String comment;
    @Column(name = "review_date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss") //ejemplo 13-05-2025T21:35:00
    LocalDateTime reviewDate;
}
