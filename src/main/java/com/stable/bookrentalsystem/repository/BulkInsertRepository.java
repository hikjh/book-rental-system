package com.stable.bookrentalsystem.repository;

import com.stable.bookrentalsystem.domain.book.entity.Book;

import java.util.List;

public interface BulkInsertRepository {
    void bulkInsert(List<Book> books);
}