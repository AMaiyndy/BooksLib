package com.may.bookslib.service;

import com.may.bookslib.dao.BookDao;
import com.may.bookslib.model.Book;
import com.may.bookslib.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    public void addOrEditBook(Book book) {
        if(book.getId() > 0) {
            this.bookDao.updateBook(book);
        } else {
            this.bookDao.addBook(book);
        }
    }

    @Override
    public void removeBook(long id) {
        this.bookDao.removeBook(id);
    }

    @Override
    public void addBookToStudent(long studentId, long bookId) {
        long currentQuantity = this.bookDao.getBookById(bookId).getQuantity();
        if(currentQuantity > 0) {
            this.bookDao.addBookToStudent(studentId, bookId);
            this.bookDao.changeBookQuantity(--currentQuantity, bookId);
        } else {
            System.out.println("Book is not available");
        }
    }

    @Override
    public void returnBook(long studentId, long bookId) {
        long currentQuantity = this.bookDao.getBookById(bookId).getQuantity();
        this.bookDao.returnBook(studentId, bookId);
        this.bookDao.changeBookQuantity(++currentQuantity, bookId);
    }

    @Override
    public Book getBookById(long id) {
        return this.bookDao.getBookById(id);
    }

    @Override
    public List<Book> getListOfBooks() {
        return this.bookDao.getListOfBooks();
    }

    @Override
    public List<Book> getBooksOfStudent(long id) {
        return this.bookDao.getBooksOfStudent(id);
    }
}
