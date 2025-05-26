package com.portfolio.bookclub.bookclub.presentation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.bookclub.bookclub.presentation.dto.EventCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.EventDto;
import com.portfolio.bookclub.bookclub.service.interfaces.EventService;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long id) {
        EventDto event = eventService.getById(id);
        return ResponseEntity.ok(event);
    }
    @GetMapping("/all")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventService.getAll();
        return ResponseEntity.ok(events);
    }
    @PostMapping
    public ResponseEntity<EventDto> createEvent(@RequestBody EventCreateDto eventDto) {
        EventDto createdEvent = eventService.create(eventDto);
        return ResponseEntity.ok(createdEvent);
    }
    @PostMapping("/update")
    public ResponseEntity<EventDto> updateEvent(@RequestBody EventDto eventDto) {
        EventDto updatedEvent = eventService.update(eventDto);
        return ResponseEntity.ok(updatedEvent);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
