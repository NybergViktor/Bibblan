package com.bibblan.bibblan.controllers;

import com.bibblan.bibblan.services.BorrowedBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/borrowedBooks")
public class BorrowedBooksController {
    @Autowired
    BorrowedBooksService borrowedBooksService;
}
