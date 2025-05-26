package com.portfolio.bookclub.bookclub.service.interfaces;

import java.util.List;

import com.portfolio.bookclub.bookclub.presentation.dto.ClubCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.ClubDto;

public interface ClubService {
    public ClubDto getById(Long id);
    public List<ClubDto> getAll();
    public ClubDto create(ClubCreateDto clubCreateDto);
    public ClubDto update(ClubDto clubDto);
    public void delete(Long id);

}
