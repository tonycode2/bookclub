package com.portfolio.bookclub.bookclub.service.http;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.portfolio.bookclub.bookclub.presentation.dto.BookItem;
import com.portfolio.bookclub.bookclub.presentation.dto.BookSearchResponse;

@Service
public class GoogleBookService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://www.googleapis.com/books/v1/volumes";

    public BookSearchResponse searchBooks(String query){
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("q", query)
                .queryParam("maxResults", 5)
                .toUriString();

        ResponseEntity<BookSearchResponse> response = restTemplate.getForEntity(url, BookSearchResponse.class);

        return response.getBody();
    }

    public BookItem getBookById(String id) {
        String url = BASE_URL + "/" + id;
        return restTemplate.getForObject(url, BookItem.class);
    }
}
