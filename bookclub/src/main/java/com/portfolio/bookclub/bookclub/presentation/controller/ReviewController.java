package com.portfolio.bookclub.bookclub.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.bookclub.bookclub.presentation.dto.ReviewCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.ReviewDto;
import com.portfolio.bookclub.bookclub.service.interfaces.ReviewService;

@RequestMapping("/api/v1/review")
@RestController
public class ReviewController {
    private final ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewCreateDto reviewCreateDto) {
        ReviewDto createdReview = reviewService.create(reviewCreateDto);
        return ResponseEntity.ok(createdReview);
    }

    @PostMapping("/update")
    public ResponseEntity<ReviewDto> updateReview(@RequestBody ReviewDto reviewDto) {
        ReviewDto updatedReview = reviewService.update(reviewDto);
        return ResponseEntity.ok(updatedReview);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReview(@RequestBody Long id) {
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
