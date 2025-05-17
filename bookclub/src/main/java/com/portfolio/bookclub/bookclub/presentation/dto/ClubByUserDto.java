package com.portfolio.bookclub.bookclub.presentation.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubByUserDto {
    
    Long id;
    Integer userId;
    Long clubId;
    LocalDateTime joinDate;
}
