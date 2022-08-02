package com.github.GypsyJR777.MyBookShopApp.controller;

import com.github.GypsyJR777.MyBookShopApp.entity.Book;
import com.github.GypsyJR777.MyBookShopApp.service.AuthorService;
import com.github.GypsyJR777.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainPageController {
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public MainPageController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        return bookService.getBooksData();
    }

    @GetMapping("/")
    public String mainPage() {
//        model.addAttribute("bookData", bookService.getBooksData());
//        model.addAttribute("searchPlaceholder", "new search placeholder");
//        model.addAttribute("serverTime", new SimpleDateFormat("hh:mm:ss").format(new Date()));
//        model.addAttribute("placeholderTextPart2", "SERVER");
//        model.addAttribute("messageTemplate", "searchbar.placeholder2");

        return "index";
    }

    @GetMapping("/genres")
    public String genresPage() {
        return "genres/index";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        model.addAttribute("authors", authorService.getMapAuthorsAndFirstLetters());
        return "authors/index";
    }
}
