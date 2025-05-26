package com.portfolio.bookclub.bookclub.service.interfaces;


import com.portfolio.bookclub.bookclub.presentation.dto.ReviewCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.ReviewDto;

public interface ReviewService {
    public ReviewDto create(ReviewCreateDto reviewCreateDto);
    public ReviewDto update(ReviewDto reviewDto);
    public void delete(Long id);
}
