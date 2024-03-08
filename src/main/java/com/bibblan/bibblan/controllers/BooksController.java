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
    @PutMapping("/update/{id}")
    public Books updateBooks(@PathVariable String id,  @RequestBody Books booksDetails) {
        return booksService.updateBooks(booksDetails);
    }


    //Example

    // GET by id
    // GET a book using id
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Books getBooksById(@RequestBody Books books) {
        return booksService.booksById(books);
    }

    // DELETE
    // Delete book
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteBooks(@PathVariable String id, @RequestBody Books books) {
        return booksService.deleteBooks(books);
    }
}
