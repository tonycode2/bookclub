package com.portfolio.bookclub.bookclub.presentation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookshelfByUserCreateDto {

    Integer userId;
    String bookId;
    @Builder.Default
    Boolean isCompleted = false;
    @Builder.Default
    Boolean isStarted = false;
}
