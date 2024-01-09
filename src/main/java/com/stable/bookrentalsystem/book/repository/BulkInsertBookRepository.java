package com.stable.bookrentalsystem.book.repository;

import com.stable.bookrentalsystem.book.domain.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class BulkInsertBookRepository implements BulkInsertRepository {

    private final NamedParameterJdbcTemplate template;

    public BulkInsertBookRepository(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void bulkInsert(List<Book> books) {

        String sql = createBulkInsertSQL();
        SqlParameterSource[] params = mapToBookSQLParameterSource(books);

        template.batchUpdate(sql, params);
    }

    private String createBulkInsertSQL() {
        return "INSERT INTO book (book_id, title, author, publisher, publish_year, is_rented, created_date, modified_date)" +
                " VALUES (:id, :title, :author, :publisher, :publishYear, :rented, now(), now())";
    }

    private SqlParameterSource[] mapToBookSQLParameterSource(List<Book> books) {
        return books.stream()
                .map(BeanPropertySqlParameterSource::new)
                .toArray(SqlParameterSource[]::new);
    }
}
