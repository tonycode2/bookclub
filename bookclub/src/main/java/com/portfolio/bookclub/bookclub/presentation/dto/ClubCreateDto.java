package com.portfolio.bookclub.bookclub.presentation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubCreateDto {
    String name;
    String clubCategory;
    String description;
    String bookOfTheWeekId;
}
