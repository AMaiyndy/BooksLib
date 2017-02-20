package com.may.bookslib.dao;

import com.may.bookslib.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDaoImpl implements BookDao {
    private JdbcTemplate jdbcTemplate;

    public void addBook(Book book) {

    }

    public void updateBook(Book book) {

    }

    public void removeBook(long id) {

    }

    public Book getBookById(long id) {
        return null;
    }

    public List<Book> getListOfBooks() {
        return null;
    }
}
