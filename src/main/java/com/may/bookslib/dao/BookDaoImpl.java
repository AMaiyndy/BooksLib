package com.may.bookslib.dao;

import com.may.bookslib.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO books (BOOK_TITLE, BOOK_AUTHOR, BOOK_QUANTITY) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, book.getBookTitle(), book.getBookAuthor(), book.getBookQuantity());
    }

    @Override
    public void updateBook(Book book) {
        String sql = "UPDATE books SET BOOK_TITLE=?, BOOK_AUTHOR=?, BOOK_QUANTITY=? WHERE ID=?";
        jdbcTemplate.update(sql, book.getBookTitle(), book.getBookAuthor(), book.getBookQuantity(), book.getId());
    }

    @Override
    public void removeBook(long id) {
        String sql = "DELETE FROM books WHERE ID=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Book getBookById(long id) {
        String sql = "SELECT * FROM books WHERE ID=" + id;

        return jdbcTemplate.queryForObject(sql, new BookRowMapper(), id);
    }

    @Override
    public List<Book> getListOfBooks() {
        String sql = "SELECT * FROM books";

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
