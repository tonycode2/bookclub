package com.portfolio.bookclub.bookclub.service.implementation;

import com.portfolio.bookclub.bookclub.persistance.entity.Review;
import com.portfolio.bookclub.bookclub.persistance.repository.ReviewRepo;
import com.portfolio.bookclub.bookclub.presentation.dto.ReviewCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.ReviewDto;
import com.portfolio.bookclub.bookclub.service.interfaces.ReviewService;
import com.portfolio.bookclub.bookclub.util.mapper.ReviewMapper;

public class ReviewImpl implements ReviewService{

    private final ReviewRepo repo;
    private final ReviewMapper mapper;
    public ReviewImpl(ReviewRepo repo, ReviewMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }


    public ReviewDto create(ReviewCreateDto reviewCreateDto) {
        Review reviewDto = mapper.fromCreateToEntity(reviewCreateDto);
        Review savedReview = repo.save(reviewDto);
        if (savedReview == null) {
            return null;
        }
        return mapper.toDto(savedReview);
    }

    public ReviewDto update(ReviewDto reviewDto) {
        Review review = mapper.toEntity(reviewDto);
        Review updatedReview = repo.save(review);
        if (updatedReview == null) {
            return null;
        }
        return mapper.toDto(updatedReview);
    }

    public void delete(Long id) {
        Review review = repo.findById(id).orElse(null);
        if (review != null) {
            repo.delete(review);
        }
    }

}
