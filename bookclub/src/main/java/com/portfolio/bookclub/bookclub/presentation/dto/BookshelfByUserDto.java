package com.portfolio.bookclub.bookclub.presentation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookshelfByUserDto {

    Long id;
    Integer userId;
    String bookId;
    Boolean isCompleted;
    Boolean isStarted;

}
