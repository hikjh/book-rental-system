package com.stable.bookrentalsystem.repository.book;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.stable.bookrentalsystem.web.dto.book.BookResponseDTO;
import com.stable.bookrentalsystem.web.dto.book.BookSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

import static com.stable.bookrentalsystem.domain.book.entity.QBook.book;

@RequiredArgsConstructor
@Repository
public class CustomBookRepositoryImpl implements CustomBookRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<BookResponseDTO> findAllBooks(BookSearchCond cond, Pageable pageable) {
        return jpaQueryFactory
                .select(Projections.fields(BookResponseDTO.class,
                        book.id,
                        book.title,
                        book.author,
                        book.publisher,
                        book.publishYear,
                        book.isRented
                ))
                .from(book)
                .where(
                        titleContains(cond.searchTitle()),
                        authorContains(cond.searchAuthor()),
                        publisherContains(cond.searchPublisher())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    private BooleanExpression titleContains(String title) {
        return Objects.nonNull(title) ? book.title.contains(title) : null;
    }

    private BooleanExpression authorContains(String author) {
        return Objects.nonNull(author) ? book.author.contains(author) : null;
    }

    private BooleanExpression publisherContains(String searchPublisher) {
        return Objects.nonNull(searchPublisher) ? book.publisher.contains(searchPublisher) : null;
    }
}
