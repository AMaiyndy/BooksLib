package com.may.bookslib.dao;

import com.may.bookslib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_INSERT = "INSERT INTO books (BOOK_TITLE, BOOK_AUTHOR, BOOK_QUANTITY) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE books SET BOOK_TITLE=?, BOOK_AUTHOR=?, BOOK_QUANTITY=? WHERE ID=?";
    private static final String SQL_DELETE = "DELETE FROM books WHERE ID=?";
    private static final String SQL_SELECT = "SELECT * FROM books";
    private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE ID=?";

    @Autowired
    public void setJdbcTemplate(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addBook(Book book) {
        String sql = SQL_INSERT;
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getQuantity());
    }

    @Override
    public void updateBook(Book book) {
        String sql = SQL_UPDATE;
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getQuantity(), book.getId());
    }

    @Override
    public void removeBook(long id) {
        String sql = SQL_DELETE;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Book getBookById(long id) {
        String sql = SQL_SELECT_BY_ID;

        return jdbcTemplate.queryForObject(sql, new BookRowMapper(), id);
    }

    @Override
    public List<Book> getListOfBooks() {
        String sql = SQL_SELECT;

        return jdbcTemplate.query(sql, new BookRowMapper());
    }


    private static final class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            return new Book(
                    rs.getLong("ID"),
                    rs.getString("BOOK_TITLE"),
                    rs.getString("BOOK_AUTHOR"),
                    rs.getLong("BOOK_QUANTITY"));
        }
    }
}
