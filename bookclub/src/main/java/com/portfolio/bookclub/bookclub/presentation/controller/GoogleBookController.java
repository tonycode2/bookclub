package com.portfolio.bookclub.bookclub.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.bookclub.bookclub.presentation.dto.BookItem;
import com.portfolio.bookclub.bookclub.presentation.dto.BookSearchResponse;
import com.portfolio.bookclub.bookclub.service.http.GoogleBookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class GoogleBookController {
    
    private final GoogleBookService googleBookService;

    @GetMapping("/search")
    public BookSearchResponse searchBooks(@RequestParam String q) {
        return googleBookService.searchBooks(q);
    }
    
    @GetMapping("/{id}")
    public BookItem getBookById(@PathVariable String id) {
        return googleBookService.getBookById(id);
    }
}
