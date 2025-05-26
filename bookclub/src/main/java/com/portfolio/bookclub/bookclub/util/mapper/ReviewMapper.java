package com.portfolio.bookclub.bookclub.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portfolio.bookclub.bookclub.persistance.entity.Review;
import com.portfolio.bookclub.bookclub.persistance.entity.User;
import com.portfolio.bookclub.bookclub.persistance.repository.UserRepo;
import com.portfolio.bookclub.bookclub.presentation.dto.ReviewCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.ReviewDto;
import com.portfolio.bookclub.bookclub.service.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ReviewMapper {
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    public ReviewMapper(ModelMapper modelMapper, UserRepo userRepo){
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
    }

    public Review toEntity(ReviewDto dto){
        Review entity = modelMapper.map(dto, Review.class);
        User user = userRepo.findById(dto.getUserId()).orElseThrow(()-> new UserNotFoundException(dto.getUserId()));
        entity.setUser(user);
        log.info("User mapped");
        return entity;
    }

    public Review fromCreateToEntity(ReviewCreateDto dto){
        Review entity = modelMapper.map(dto, Review.class);
        User user = userRepo.findById(dto.getUserId()).orElseThrow(()-> new UserNotFoundException(dto.getUserId()));
        entity.setUser(user);
        log.info("User mapped");
        return entity;        
    }

    public ReviewDto toDto(Review entity){
        ReviewDto dto = modelMapper.map(entity, ReviewDto.class);
        dto.setUserId(entity.getUser().getId());
        log.info("User mapped");
        return dto;
    }   
}   
