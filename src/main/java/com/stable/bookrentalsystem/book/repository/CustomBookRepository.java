package com.stable.bookrentalsystem.book.repository;

import com.stable.bookrentalsystem.book.controller.dto.BookResponseDTO;
import com.stable.bookrentalsystem.book.controller.dto.BookSearchCond;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomBookRepository {
    List<BookResponseDTO> findAllBooks(BookSearchCond cond, Pageable pageable);
}
