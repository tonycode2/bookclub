package com.portfolio.bookclub.bookclub.service.interfaces;

import com.portfolio.bookclub.bookclub.presentation.dto.ClubByUserDto;

public interface ClubByUserService {
    public ClubByUserDto create(Integer userId, Long clubId);
    public void delete(Integer userId, Long clubId);
}
