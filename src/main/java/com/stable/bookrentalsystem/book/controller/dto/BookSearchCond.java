package com.stable.bookrentalsystem.book.controller.dto;

public record BookSearchCond(
    String searchTitle,
    String searchAuthor,
    String searchPublisher
) {}
