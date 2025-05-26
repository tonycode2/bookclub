package com.portfolio.bookclub.bookclub.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.bookclub.bookclub.presentation.dto.ClubByUserDto;
import com.portfolio.bookclub.bookclub.service.interfaces.ClubByUserService;

@RestController
@RequestMapping("/api/v1/club-by-user")
public class ClubByUserController {

    private final ClubByUserService service;
    public ClubByUserController(ClubByUserService service) {
        this.service = service;
    }

    @PostMapping("/{userId}/{clubId}")
    public ResponseEntity<ClubByUserDto> create(@PathVariable Integer userId, @PathVariable Long clubId) {
        ClubByUserDto created = service.create(userId, clubId);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Integer userId, @PathVariable Long clubId) {
        service.delete(userId, clubId);
        return ResponseEntity.noContent().build();
    }


}
