package com.stable.bookrentalsystem.book.domain.entity;

import com.stable.bookrentalsystem.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Table
@Entity
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String publishYear;
    private boolean isRented;

    @Builder
    public Book(Long id, String title, String author, String publisher, String publishYear, boolean isRented) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.isRented = isRented;
    }

    public static Book of(Long id, String title, String author, String publisher, String publishYear) {
        return Book.builder()
                .id(id)
                .title(title)
                .author(author)
                .publisher(publisher)
                .publishYear(publishYear)
                .isRented(false)
                .build();
    }
}
