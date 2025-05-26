package com.portfolio.bookclub.bookclub.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portfolio.bookclub.bookclub.persistance.entity.Club;
import com.portfolio.bookclub.bookclub.persistance.entity.Event;
import com.portfolio.bookclub.bookclub.persistance.entity.enums.EventStatus;
import com.portfolio.bookclub.bookclub.persistance.entity.enums.EventType;
import com.portfolio.bookclub.bookclub.persistance.repository.ClubRepo;
import com.portfolio.bookclub.bookclub.presentation.dto.EventCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.EventDto;
import com.portfolio.bookclub.bookclub.service.exception.ClubNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventMapper {
    private final ModelMapper modelMapper;
    private final ClubRepo clubRepo;
    
    public EventMapper(ModelMapper modelMapper, ClubRepo clubRepo){
        this.modelMapper = modelMapper;
        this.clubRepo = clubRepo;
    }

    public Event toEntity(EventDto dto){
        Event entity = modelMapper.map(dto, Event.class);
        Club club = clubRepo.findById(dto.getClubId()).orElseThrow(() -> new ClubNotFoundException(dto.getClubId()));
        entity.setClub(club);
        log.info("Club located and mapped");
        entity.setEventType(EventType.valueOf(dto.getEventType()));
        log.info("Event Type mapped");
        entity.setEventStatus(EventStatus.valueOf(dto.getEventStatus()));
        log.info("Event Status mapped");
        return entity;
        
    }

    public Event fromCreateToEntity(EventCreateDto dto){
        Event entity = modelMapper.map(dto, Event.class);
        Club club = clubRepo.findById(dto.getClubId()).orElseThrow(() -> new ClubNotFoundException(dto.getClubId()));
        entity.setClub(club);
        log.info("Club located and mapped");
        entity.setEventType(EventType.valueOf(dto.getEventType()));
        log.info("Event Type mapped");
        entity.setEventStatus(EventStatus.valueOf(dto.getEventStatus()));
        log.info("Event Status mapped");
        return entity;
    }
    
    public EventDto toDto(Event entity){
        EventDto dto = modelMapper.map(entity, EventDto.class);
        dto.setClubId(entity.getClub().getId());
        log.info("Club Id mapped");
        dto.setEventStatus(entity.getEventStatus().name());
        log.info("Event Status mapped");
        dto.setEventType(entity.getEventType().name()); 
        return dto;        
    }
}
