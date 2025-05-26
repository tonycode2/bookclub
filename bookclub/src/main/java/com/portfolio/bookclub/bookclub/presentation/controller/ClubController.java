package com.portfolio.bookclub.bookclub.presentation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.bookclub.bookclub.presentation.dto.ClubCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.ClubDto;
import com.portfolio.bookclub.bookclub.service.interfaces.ClubService;

@RestController
@RequestMapping("/api/v1/club")
public class ClubController {
    private final ClubService clubService;
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDto> getClubsByUserId(@PathVariable Long id) {
        ClubDto clubs = clubService.getById(id);
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClubDto>> getAllClubs() {
        List<ClubDto> clubs = clubService.getAll();
        return ResponseEntity.ok(clubs);
    }
    @PostMapping
    public ResponseEntity<ClubDto> createClub(@RequestBody ClubCreateDto clubCreateDto) {
        ClubDto createdClub = clubService.create(clubCreateDto);
        return ResponseEntity.ok(createdClub);
    }
    @PostMapping("/update")
    public ResponseEntity<ClubDto> updateClub(@RequestBody ClubDto clubDto) {
        ClubDto updatedClub = clubService.update(clubDto);
        return ResponseEntity.ok(updatedClub);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
        clubService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
