package com.may.bookslib.model;

public class Book {
    private long id;
    private String bookTitle;
    private String bookAuthor;
    private long bookQuantity;

    public Book() {
    }

    public Book(long id, String bookTitle, String bookAuthor, long bookQuantity) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookQuantity = bookQuantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public long getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(long bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookQuantity=" + bookQuantity +
                '}';
    }
}
