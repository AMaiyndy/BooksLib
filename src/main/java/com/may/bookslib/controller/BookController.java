package com.may.bookslib.controller;

import com.may.bookslib.model.Book;
import com.may.bookslib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/")
    public String getHomePage() {

        return "books";
    }

//    Get all books
    @RequestMapping(value = "/books/", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBooks() {
        List<Book> books = this.bookService.getListOfBooks();
        if(books.isEmpty()) {
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
//    Get book by id
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
        System.out.println("Fetching Book with id " + id);
        Book book = this.bookService.getBookById(id);
        if(book == null) {
            System.out.println("Book with id" + id + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
//    Create a book
    @RequestMapping(value = "/books/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody Book book, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Book " + book.getTitle());
        this.bookService.addOrEditBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

//    Update a book
    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
        System.out.println("Updating Book " + id);

        Book currentBook = this.bookService.getBookById(id);

        if(currentBook == null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

        currentBook.setTitle(book.getTitle());
        currentBook.setAuthor(book.getAuthor());
        currentBook.setQuantity(book.getQuantity());

        this.bookService.addOrEditBook(currentBook);
        return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
    }

//    Delete a book
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
        System.out.println("Fetching and Deleting Book with id " + id);

        Book book = this.bookService.getBookById(id);
        if(book == null) {
            System.out.println("Unable to delete. Book with id " + id + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

        this.bookService.removeBook(id);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
}
