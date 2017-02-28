package com.may.bookslib.service;

import com.may.bookslib.model.Book;

import java.util.List;

public interface BookService {
    void addOrEditBook(Book book);

    void removeBook(long id);

    Book getBookById(long id);

    List<Book> getListOfBooks();
}
