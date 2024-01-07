package com.stable.bookrentalsystem.web;

import com.stable.bookrentalsystem.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
