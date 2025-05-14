package com.portfolio.bookclub.bookclub.presentation.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSearchResponse {
    private List<BookItem> items;
}
