package com.portfolio.bookclub.bookclub.persistance.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portfolio.bookclub.bookclub.persistance.entity.enums.EventStatus;
import com.portfolio.bookclub.bookclub.persistance.entity.enums.EventType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "event")
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    Club club;
    @Column(name = "event_date_time", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss") //ejemplo 13-05-2025T21:35:00
    LocalDateTime eventDateTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    EventType eventType;
    @Enumerated(EnumType.STRING)
    @Column(name = "event_status", nullable = false)
    EventStatus eventStatus;
}
