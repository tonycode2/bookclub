package com.portfolio.bookclub.bookclub.service.implementation;

import java.util.List;

import com.portfolio.bookclub.bookclub.persistance.entity.Event;
import com.portfolio.bookclub.bookclub.persistance.repository.EventRepo;
import com.portfolio.bookclub.bookclub.presentation.dto.EventCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.EventDto;
import com.portfolio.bookclub.bookclub.service.interfaces.EventService;
import com.portfolio.bookclub.bookclub.util.mapper.EventMapper;

public class EventImpl implements EventService{

    private final EventRepo repo;
    private final EventMapper mapper;

    public EventImpl(EventRepo repo, EventMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public EventDto getById(Long id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    public List<EventDto> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public EventDto create(EventCreateDto eventCreateDto) {
        Event event = mapper.fromCreateToEntity(eventCreateDto);
        Event savedEvent = repo.save(event);
        if (savedEvent == null) {
            return null;
        }
        return mapper.toDto(savedEvent);
    }

    public EventDto update(EventDto eventDto) {
        Event event = mapper.toEntity(eventDto);
        Event updatedEvent = repo.save(event);
        if (updatedEvent == null) {
            return null;
        }
        return mapper.toDto(updatedEvent);
        
    }

    public void delete(Long id) {
        Event event = repo.findById(id).orElse(null);
        if (event != null) {
            repo.delete(event);
        }
    }

}
