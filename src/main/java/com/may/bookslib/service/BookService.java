package com.may.bookslib.service;

import com.may.bookslib.model.Book;
import com.may.bookslib.model.Student;

import java.util.List;

public interface BookService {
    void addOrEditBook(Book book);

    void removeBook(long id);

    void addBookToStudent(long studentId, long bookId);

    void returnBook(long studentId, long bookId);

    Book getBookById(long id);

    List<Book> getListOfBooks();

    List<Book> getBooksOfStudent(long id);
}
