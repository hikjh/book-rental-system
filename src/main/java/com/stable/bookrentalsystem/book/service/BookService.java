package com.stable.bookrentalsystem.book.service;

import com.stable.bookrentalsystem.book.controller.dto.BookResponseDTO;
import com.stable.bookrentalsystem.book.controller.dto.BookSearchCond;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    int registerBook();
    List<BookResponseDTO> searchBook(BookSearchCond cond, Pageable pageable);
}
