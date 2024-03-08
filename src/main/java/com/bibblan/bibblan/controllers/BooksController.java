package com.bibblan.bibblan.controllers;

import com.bibblan.bibblan.exception.EntityNotFoundException;
import com.bibblan.bibblan.models.Books;
import com.bibblan.bibblan.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/books")
public class BooksController {
    @Autowired
    BooksService booksService;


    // POST
    // add a new book
    @PostMapping()
    public ResponseEntity<?> createBook(@RequestBody Books books) {
        try {
             return ResponseEntity.ok(booksService.createBooks(books));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GET
    // GET all books
    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks() {
        try {
            return ResponseEntity.ok(booksService.getAllBooks());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books found.");
        }
    }

    // PUT
    // UPDATE book
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBooks(@PathVariable String id,  @RequestBody Books booksDetails) {
        try {
            return ResponseEntity.ok(booksDetails);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    //Example

    // GET by id
    // GET a book using id
    @GetMapping( "/find/{id}")
    public ResponseEntity<?> getBooksById(@PathVariable String id, @RequestBody Books books) {
        try {
            return ResponseEntity.ok( books);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE
    // Delete book

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable String id, @RequestBody Books books) {
        try {
            return ResponseEntity.ok(books);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
