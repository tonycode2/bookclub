package com.portfolio.bookclub.bookclub.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.bookclub.bookclub.persistance.entity.Club;
import com.portfolio.bookclub.bookclub.persistance.repository.ClubRepo;
import com.portfolio.bookclub.bookclub.presentation.dto.ClubCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.ClubDto;
import com.portfolio.bookclub.bookclub.service.interfaces.ClubService;
import com.portfolio.bookclub.bookclub.util.mapper.ClubMapper;

@Service
public class ClubImpl implements ClubService{

    private final ClubRepo repo;
    private final ClubMapper mapper;
    
    public ClubImpl(ClubRepo repo, ClubMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ClubDto getById(Long id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    public List<ClubDto> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ClubDto create(ClubCreateDto clubCreateDto) {
        Club club = mapper.fromCreateToDto(clubCreateDto);
        if(club == null) {
            return null;
        }
        club = repo.save(club);
        return mapper.toDto(club);
    }

    public ClubDto update(ClubDto clubDto) {
        Club club = mapper.toEntity(clubDto);
        if(club == null) {
            return null;
        }
        club = repo.save(club);
        return mapper.toDto(club);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
