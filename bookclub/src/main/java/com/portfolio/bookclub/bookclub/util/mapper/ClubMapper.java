package com.portfolio.bookclub.bookclub.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portfolio.bookclub.bookclub.persistance.entity.Club;
import com.portfolio.bookclub.bookclub.persistance.entity.enums.ClubCategory;
import com.portfolio.bookclub.bookclub.presentation.dto.ClubCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.ClubDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ClubMapper {
    private final ModelMapper modelMapper;

    public ClubMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Club toEntity(ClubDto dto){
        Club entity = modelMapper.map(dto, Club.class);
        entity.setClubCategory(ClubCategory.valueOf(dto.getClubCategory()));
        log.info("Club Category mapped");
        return entity;
    }

    public Club fromCreateToDto(ClubCreateDto dto){
        Club entity = modelMapper.map(dto, Club.class);
        entity.setClubCategory(ClubCategory.valueOf(dto.getClubCategory()));
        log.info("Club Category mapped");
        return entity;
    }

    public ClubDto toDto(Club entity){
        ClubDto dto = modelMapper.map(entity, ClubDto.class);
        dto.setClubCategory(entity.getClubCategory().name());
        log.info("Club Category mapped");
        return dto;
    }
}
