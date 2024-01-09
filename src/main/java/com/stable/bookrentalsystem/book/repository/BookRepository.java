package com.stable.bookrentalsystem.book.repository;

import com.stable.bookrentalsystem.book.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, CustomBookRepository {
}
