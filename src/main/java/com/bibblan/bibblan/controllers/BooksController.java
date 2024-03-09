package com.bibblan.bibblan.controllers;

import com.bibblan.bibblan.dto.books.FindBookDTO;
import com.bibblan.bibblan.dto.books.PostBookDTO;
import com.bibblan.bibblan.dto.books.PutBookDTO;
import com.bibblan.bibblan.exception.EntityNotFoundException;
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
    public ResponseEntity<?> createBook(@RequestBody PostBookDTO postBookDTO) {
        return booksService.createBooks(postBookDTO);
    }

    // GET
    // GET all books
    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks() {
        try {
            return ResponseEntity.ok(booksService.getAllBooks());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // PUT
    // UPDATE book
    @PutMapping()
    public ResponseEntity<?> updateBooks(@RequestBody PutBookDTO putBookDTO) {
        try {
            return booksService.updateBooks(putBookDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }




    // GET by id
    // GET a book using id
    @GetMapping( "/find")
    public ResponseEntity<?> getBooksById(@RequestBody FindBookDTO findBookDTO) {
        try {
            return booksService.booksById(findBookDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE
    // Delete book

    @DeleteMapping()
    public ResponseEntity<?> deleteBooks(@RequestBody FindBookDTO findBookDTO) {
        try {
            return booksService.deleteBooks(findBookDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
