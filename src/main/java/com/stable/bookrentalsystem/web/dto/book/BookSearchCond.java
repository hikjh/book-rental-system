package com.stable.bookrentalsystem.web.dto.book;

public record BookSearchCond(
    String searchTitle,
    String searchAuthor,
    String searchPublisher
) {}
