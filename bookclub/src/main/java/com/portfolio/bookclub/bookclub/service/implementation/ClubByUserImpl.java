package com.portfolio.bookclub.bookclub.service.implementation;

import org.springframework.stereotype.Service;

import com.portfolio.bookclub.bookclub.persistance.entity.ClubByUser;
import com.portfolio.bookclub.bookclub.persistance.repository.ClubByUserRepo;
import com.portfolio.bookclub.bookclub.presentation.dto.ClubByUserDto;
import com.portfolio.bookclub.bookclub.service.interfaces.ClubByUserService;
import com.portfolio.bookclub.bookclub.util.mapper.ClubByUserMapper;

@Service
public class ClubByUserImpl implements ClubByUserService {
    private final ClubByUserRepo repo;
    private final ClubByUserMapper mapper;
    public ClubByUserImpl(ClubByUserRepo repo, ClubByUserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ClubByUserDto create(Integer userId, Long clubId) {
        ClubByUserDto clubByUserDto = ClubByUserDto.builder()
                .userId(userId)
                .clubId(clubId)
                .joinDate(java.time.LocalDateTime.now())
                .build();
        ClubByUser clubByUser = repo.save(mapper.toEntity(clubByUserDto));
        if (clubByUser == null) {
            return null;
        }
        return mapper.toDto(clubByUser);
    }

    public void delete(Integer userId, Long clubId) {
        ClubByUser clubByUser = repo.findByUserIdAndClubId(userId, clubId).orElse(null);
        if (clubByUser != null) {
            repo.delete(clubByUser);
        }
    }
}
