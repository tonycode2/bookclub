package com.portfolio.bookclub.bookclub.service.interfaces;

import java.util.List;

import com.portfolio.bookclub.bookclub.presentation.dto.BookshelfByUserCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.BookshelfByUserDto;

public interface BookshelfByUserService {
    public List<BookshelfByUserDto> getByUserId(Integer id);
    public BookshelfByUserDto create(BookshelfByUserCreateDto bookshelfByUserCreateDto);
    public BookshelfByUserDto update(BookshelfByUserDto bookshelfByUserDto);
    public void delete(Long id);
}
