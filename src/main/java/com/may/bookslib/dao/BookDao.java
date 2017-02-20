package com.may.bookslib.dao;

import com.may.bookslib.model.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(long id);

    Book getBookById(long id);

    List<Book> getListOfBooks();
}
