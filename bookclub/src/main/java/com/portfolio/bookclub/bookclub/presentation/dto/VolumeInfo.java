package com.portfolio.bookclub.bookclub.presentation.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VolumeInfo {
    private String title;
    private List<String> authors;
    private String publishedDate;
    private String description;
    private ImageLinks imageLinks;
}
