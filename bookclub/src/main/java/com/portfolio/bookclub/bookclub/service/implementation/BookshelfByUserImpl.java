package com.portfolio.bookclub.bookclub.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.bookclub.bookclub.persistance.entity.BookshelfByUser;
import com.portfolio.bookclub.bookclub.persistance.repository.BookshelfByUserRepo;
import com.portfolio.bookclub.bookclub.presentation.dto.BookshelfByUserCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.BookshelfByUserDto;
import com.portfolio.bookclub.bookclub.service.interfaces.BookshelfByUserService;
import com.portfolio.bookclub.bookclub.util.mapper.BookshelfByUserMapper;

@Service
public class BookshelfByUserImpl implements BookshelfByUserService{

    private final BookshelfByUserRepo repo;
    private final BookshelfByUserMapper mapper;

    public BookshelfByUserImpl(BookshelfByUserRepo repo, BookshelfByUserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<BookshelfByUserDto> getByUserId(Integer id) {
        List<BookshelfByUser> bookshelfs = repo.findByUserId(id);
        if(bookshelfs.isEmpty()){
            return null;
        }
        return bookshelfs.stream()
                .map(mapper::toDto)
                .toList();
    }

    public BookshelfByUserDto create(BookshelfByUserCreateDto bookshelfByUserCreateDto) {
        BookshelfByUser bookshelf = mapper.fromCreateToEntity(bookshelfByUserCreateDto);
        bookshelf = repo.save(bookshelf);
        if(bookshelf == null){
            return null;
        }
        return mapper.toDto(bookshelf);
    }

    public BookshelfByUserDto update(BookshelfByUserDto bookshelfByUserDto) {
        BookshelfByUser bookshelf = mapper.toEntity(bookshelfByUserDto);
        bookshelf = repo.save(bookshelf);
        if(bookshelf == null){
            return null;
        }
        return mapper.toDto(bookshelf);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


}
