package com.bibblan.bibblan.controllers;

import com.bibblan.bibblan.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/books")
public class BooksController {
    @Autowired
    BooksService booksService;


}
