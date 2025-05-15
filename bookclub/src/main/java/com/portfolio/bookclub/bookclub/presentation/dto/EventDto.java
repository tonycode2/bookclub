package com.portfolio.bookclub.bookclub.presentation.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDto {

    Long id;
    String name;
    Long clubId;
    LocalDateTime eventDateTime;
    String eventType;
    String eventStatus;
}
