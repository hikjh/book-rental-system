package com.stable.bookrentalsystem.web.dto.book;

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
