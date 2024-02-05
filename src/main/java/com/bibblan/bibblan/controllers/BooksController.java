package com.bibblan.bibblan.controllers;

import com.bibblan.bibblan.models.Books;
import com.bibblan.bibblan.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/books")
public class BooksController {
    @Autowired
    BooksService booksService;


    // POST
    // add a new book
    @PostMapping()
    public Books createBook(@RequestBody Books books) {
        return booksService.createBooks(books);
    }

    // GET
    // GET all books
    @GetMapping("/all")
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    // PUT
    // UPDATE book
    @PutMapping()
    public Books updateBooks(@RequestBody Books books) {
        return booksService.updateBooks(books);
    }

    // GET by id
    // GET a book using id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Books getBooksById(@PathVariable String id) {
        return booksService.booksById(id);
    }

    // DELETE
    // Delete book
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBooks(@PathVariable String id) {
        return booksService.deleteBooks(id);
    }
}
