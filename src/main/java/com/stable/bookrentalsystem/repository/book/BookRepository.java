package com.stable.bookrentalsystem.repository.book;

import com.stable.bookrentalsystem.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
