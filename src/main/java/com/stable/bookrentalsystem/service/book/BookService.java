package com.stable.bookrentalsystem.service.book;

import com.stable.bookrentalsystem.web.dto.book.BookResponseDTO;
import com.stable.bookrentalsystem.web.dto.book.BookSearchCond;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    int registerBook();
    List<BookResponseDTO> searchBook(BookSearchCond cond, Pageable pageable);
}
