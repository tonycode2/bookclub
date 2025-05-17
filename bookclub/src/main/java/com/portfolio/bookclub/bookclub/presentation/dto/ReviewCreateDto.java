package com.portfolio.bookclub.bookclub.presentation.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewCreateDto {
    Integer userId;
    String bookId;
    Integer rating;
    String comment;
    LocalDateTime reviewDate;
}
