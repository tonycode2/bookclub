package com.portfolio.bookclub.bookclub.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.portfolio.bookclub.bookclub.persistance.entity.BookshelfByUser;
import com.portfolio.bookclub.bookclub.persistance.entity.User;
import com.portfolio.bookclub.bookclub.persistance.repository.UserRepo;
import com.portfolio.bookclub.bookclub.presentation.dto.BookshelfByUserCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.BookshelfByUserDto;
import com.portfolio.bookclub.bookclub.service.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Component
@Lazy
@Slf4j
public class BookshelfByUserMapper {
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    BookshelfByUserMapper(ModelMapper modelMapper, UserRepo userRepo){
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
    }

    public BookshelfByUser toEntity(BookshelfByUserDto dto){
        BookshelfByUser entity = modelMapper.map(dto, BookshelfByUser.class);
        User user = userRepo.findById(dto.getUserId()).orElseThrow(() -> new UserNotFoundException(dto.getUserId()));
        entity.setUser(user);
        log.info("User with id {} was found and mapped", user.getId());
        return entity;
    }

    public BookshelfByUser fromCreateToEntity(BookshelfByUserCreateDto dto){
        BookshelfByUser entity = modelMapper.map(dto, BookshelfByUser.class);
        User user = userRepo.findById(dto.getUserId()).orElseThrow(() -> new UserNotFoundException(dto.getUserId()));
        entity.setUser(user);
        log.info("User with id {} was found and mapped", user.getId());
        return entity;
    }

    public BookshelfByUserDto toDto(BookshelfByUser entity){
        BookshelfByUserDto dto = modelMapper.map(entity, BookshelfByUserDto.class);
        dto.setUserId(entity.getUser().getId());
        log.info("Entity with id {} was mapped and is now a dto", dto.getId());
        return dto;
    }

}
