package com.portfolio.bookclub.bookclub.presentation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.bookclub.bookclub.presentation.dto.BookshelfByUserCreateDto;
import com.portfolio.bookclub.bookclub.presentation.dto.BookshelfByUserDto;
import com.portfolio.bookclub.bookclub.service.interfaces.BookshelfByUserService;


@RestController
@RequestMapping("/api/v1/bookshelf/")
public class BookshelfByUserController {

    private final BookshelfByUserService service;
    public BookshelfByUserController(BookshelfByUserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    public ResponseEntity<List<BookshelfByUserDto>> getByUserId(@PathVariable Integer id){
        return ResponseEntity.ok(service.getByUserId(id));
    }
    @PostMapping
    public ResponseEntity<BookshelfByUserDto> create(@RequestBody BookshelfByUserCreateDto bookshelfByUserCreateDto) {
        return ResponseEntity.ok(service.create(bookshelfByUserCreateDto));
    }
    @PostMapping("/update")
    public ResponseEntity<BookshelfByUserDto> update(@RequestBody BookshelfByUserDto bookshelfByUserDto) {
        return ResponseEntity.ok(service.update(bookshelfByUserDto));
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
