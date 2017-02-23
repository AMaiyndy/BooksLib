package com.may.bookslib.controller;

import com.may.bookslib.model.Book;
import com.may.bookslib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/")
    public String homePage() {

        return "index";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String booksPage(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.getListOfBooks());

        return "books";
    }

    @RequestMapping(value = "/addbook")
    public String addOrEditBookPage(Model model) {
        model.addAttribute("book", new Book());

        return "addOrEditBookPage";
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        if(book.getId() > 0) {
            this.bookService.updateBook(book);
        } else {
            this.bookService.addBook(book);
        }

        return "redirect:books";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.getListOfBooks());

        return "addOrEditBookPage";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeBook(@PathVariable("id") long id) {
        this.bookService.removeBook(id);

        return "redirect:/books";
    }

    @RequestMapping(value = "/bookdata/{id}")
    public String bookData(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }
}
