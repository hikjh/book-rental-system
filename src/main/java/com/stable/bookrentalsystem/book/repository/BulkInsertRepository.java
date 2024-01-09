package com.stable.bookrentalsystem.book.repository;

import com.stable.bookrentalsystem.book.domain.entity.Book;

import java.util.List;

public interface BulkInsertRepository {
    void bulkInsert(List<Book> books);
}
