package com.stable.bookrentalsystem.repository.book;

import com.stable.bookrentalsystem.web.dto.book.BookResponseDTO;
import com.stable.bookrentalsystem.web.dto.book.BookSearchCond;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomBookRepository {
    List<BookResponseDTO> findAllBooks(BookSearchCond cond, Pageable pageable);
}
