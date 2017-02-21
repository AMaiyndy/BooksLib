package com.may.bookslib.service;

import com.may.bookslib.dao.BookDao;
import com.may.bookslib.model.Book;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);
    }

    @Override
    public void removeBook(long id) {
        this.bookDao.removeBook(id);
    }

    @Override
    public Book getBookById(long id) {
        return this.bookDao.getBookById(id);
    }

    @Override
    public List<Book> getListOfBooks() {
        return this.bookDao.getListOfBooks();
    }
}
