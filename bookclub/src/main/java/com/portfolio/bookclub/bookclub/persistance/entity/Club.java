package com.portfolio.bookclub.bookclub.persistance.entity;

import com.portfolio.bookclub.bookclub.persistance.entity.enums.ClubCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "club")
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "club_category", nullable = false)
    ClubCategory clubCategory;
    @Column(nullable = false)
    String description;
    @Column(name = "book_of_the_week_id")
    String bookOfTheWeekId;
}
