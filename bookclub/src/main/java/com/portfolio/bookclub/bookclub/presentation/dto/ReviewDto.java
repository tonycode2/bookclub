package com.portfolio.bookclub.bookclub.presentation.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {
    Long id;
    Integer userId;
    String bookId;
    Integer rating;
    String comment;
    LocalDateTime reviewDate;
}
