package com.portfolio.bookclub.bookclub.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portfolio.bookclub.bookclub.persistance.entity.Club;
import com.portfolio.bookclub.bookclub.persistance.entity.ClubByUser;
import com.portfolio.bookclub.bookclub.persistance.entity.User;
import com.portfolio.bookclub.bookclub.persistance.repository.ClubRepo;
import com.portfolio.bookclub.bookclub.persistance.repository.UserRepo;
import com.portfolio.bookclub.bookclub.presentation.dto.ClubByUserCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.ClubByUserDto;
import com.portfolio.bookclub.bookclub.service.exception.ClubNotFoundException;
import com.portfolio.bookclub.bookclub.service.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ClubByUserMapper {
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final ClubRepo clubRepo;

    public ClubByUserMapper(ModelMapper modelMapper, UserRepo userRepo, ClubRepo clubRepo){
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
        this.clubRepo = clubRepo;
    }

    public ClubByUser toEntity(ClubByUserDto dto){
        ClubByUser entity = modelMapper.map(dto, ClubByUser.class);
        Club club = clubRepo.findById(dto.getClubId()).orElseThrow(()-> new ClubNotFoundException(dto.getClubId()));
        entity.setClub(club);
        log.info("Club located and mapped correctly");
        User user = userRepo.findById(dto.getUserId()).orElseThrow(()-> new UserNotFoundException(dto.getUserId()));
        entity.setUser(user);
        log.info("User located and mapped correctly");
        return entity;
    }

    public ClubByUser fromCreateToEntity (ClubByUserCreateDto dto){
        ClubByUser entity = modelMapper.map(dto, ClubByUser.class);
        Club club = clubRepo.findById(dto.getClubId()).orElseThrow(()-> new ClubNotFoundException(dto.getClubId()));
        entity.setClub(club);
        log.info("Club located and mapped correctly");
        User user = userRepo.findById(dto.getUserId()).orElseThrow(()-> new UserNotFoundException(dto.getUserId()));
        entity.setUser(user);
        log.info("User located and mapped correctly");
        return entity;
    }

    public ClubByUserDto toDto(ClubByUser entity){
        ClubByUserDto dto = modelMapper.map(entity, ClubByUserDto.class);
        dto.setClubId(entity.getClub().getId());
        dto.setUserId(entity.getUser().getId());
        return dto;
    }
}