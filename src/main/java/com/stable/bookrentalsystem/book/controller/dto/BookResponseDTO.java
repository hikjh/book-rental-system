package com.stable.bookrentalsystem.book.controller.dto;

import lombok.Data;

@Data
public class BookResponseDTO {

    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String publishYear;
    private boolean isRented;
}
