package com.portfolio.bookclub.bookclub.service.interfaces;

import java.util.List;

import com.portfolio.bookclub.bookclub.presentation.dto.ReviewCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.ReviewDto;

public interface ReviewService {
    public List<ReviewDto> getAllByBook(String bookId);
    public List<ReviewDto> getAllByUser(Integer userId);
    public ReviewDto create(ReviewCreateDto reviewCreateDto);
    public ReviewDto update(ReviewDto reviewDto);
    public void delete(Long id);
}
