package com.may.bookslib.model;

import java.util.HashSet;
import java.util.Set;

public class Book {
    private long id;
    private String title;
    private String author;
    private long quantity;

    public Book() {

    }

    public Book(long id, String title, String author, long quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public Book(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
