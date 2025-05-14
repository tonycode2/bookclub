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
import lombok.Data;

@Data
@Table(name = "club_per_user")
@Entity
public class ClubPerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    Club club;
    @Column(name = "join_date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss") //ejemplo 13-05-2025T21:35:00
    LocalDateTime joinDate;
}
