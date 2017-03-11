package com.may.bookslib.dao;

import com.may.bookslib.model.Book;
import com.may.bookslib.model.Student;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(long id);

    void addBookToStudent(long studentId, long bookId);

    void returnBook(long studentId, long bookId);

    void changeBookQuantity(long quantity, long id);

    Book getBookById(long id);

    List<Book> getListOfBooks();

    List<Book> getBooksOfStudent(long id);
}
