package com.example.book.controller;

import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@CrossOrigin
@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get() {
        return bookService.getHelloMessage();
    }
}
