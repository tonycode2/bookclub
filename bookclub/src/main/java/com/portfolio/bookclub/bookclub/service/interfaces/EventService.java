package com.portfolio.bookclub.bookclub.service.interfaces;

import java.util.List;

import com.portfolio.bookclub.bookclub.presentation.dto.EventCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.EventDto;

public interface EventService {
    public EventDto getById(Long id);
    public List<EventDto> getAll();
    public EventDto create(EventCreateDto eventCreateDto);
    public EventDto update(EventDto eventDto);
    public void delete(Long id);
}
