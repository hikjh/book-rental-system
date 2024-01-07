package com.stable.bookrentalsystem.web;

import com.stable.bookrentalsystem.service.book.BookService;
import com.stable.bookrentalsystem.web.dto.book.BookResponseDTO;
import com.stable.bookrentalsystem.web.dto.book.BookSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
@RestController
public class BookController {

    private final BookService bookService;

    // Controller -> Batch + Scheduler
    @PostMapping
    public int registerBook() {
        return bookService.registerBook();
    }

    @GetMapping
    public List<BookResponseDTO> searchBook(BookSearchCond cond, @PageableDefault Pageable pageable) {
        return bookService.searchBook(cond, pageable);
    }
}
