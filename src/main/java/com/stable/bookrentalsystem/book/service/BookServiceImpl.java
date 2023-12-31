package com.stable.bookrentalsystem.book.service;

import com.stable.bookrentalsystem.book.client.BookInfoFeignClient;
import com.stable.bookrentalsystem.book.client.dto.BookInfoResponse;
import com.stable.bookrentalsystem.book.controller.dto.BookResponseDTO;
import com.stable.bookrentalsystem.book.controller.dto.BookSearchCond;
import com.stable.bookrentalsystem.book.domain.entity.Book;
import com.stable.bookrentalsystem.book.repository.BookRepository;
import com.stable.bookrentalsystem.book.repository.BulkInsertRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.stable.bookrentalsystem.book.domain.entity.Book.createBook;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookInfoFeignClient bookInfoFeignClient;
    private final BulkInsertRepository bulkInsertRepository;
    private final BookRepository bookRepository;

    @Value("${client.book.serviceKey}")
    private String serviceKey;
    @Value("${client.book.pageNo}")
    private String pageNo;
    @Value("${client.book.numOfRows}")
    private String numOfRows;

    @Override
    @Transactional
    public int registerBook() {

        BookInfoResponse bookInfoResponse = bookInfoFeignClient.getBookInfo(serviceKey, pageNo, numOfRows);
        List<Book> books = mapToBookDomain(bookInfoResponse);
        log.info("### book size : {}", books.size());

        bulkInsertRepository.bulkInsert(books);
        return books.size();
    }

    @Override
    public List<BookResponseDTO> searchBook(BookSearchCond cond, Pageable pageable) {
        log.info("### cond : {}", cond);
        return bookRepository.findAllBooks(cond, pageable);
    }

    private List<Book> mapToBookDomain(BookInfoResponse bookInfoResponse) {
        return bookInfoResponse.items().stream()
                .map(bookInfo -> createBook(Long.valueOf(bookInfo.no()), bookInfo.title(), bookInfo.author(), bookInfo.publisher(), bookInfo.publishYear())).toList();
    }
}
