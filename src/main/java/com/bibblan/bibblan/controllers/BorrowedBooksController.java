package com.bibblan.bibblan.controllers;

import com.bibblan.bibblan.exception.EntityNotFoundException;
import com.bibblan.bibblan.models.BorrowedBooks;
import com.bibblan.bibblan.services.BorrowedBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/borrowedBooks")
public class BorrowedBooksController {
    @Autowired
    BorrowedBooksService borrowedBooksService;


    // POST
    //, skapar en ny lista med lånade böcker med hjälp av constructor i BorrowedBooks
    @PostMapping
    public ResponseEntity<BorrowedBooks> addBorrowedBooks(@RequestBody BorrowedBooks borrowedBooks) {
        BorrowedBooks newBorrowedBooks = borrowedBooksService.addBorrowedBooks(borrowedBooks);
        return new ResponseEntity<>(newBorrowedBooks, HttpStatus.CREATED);
    }


    // GET
    // GET all books
    @GetMapping("/all")
    public List<BorrowedBooks> getAllBorrowedBooks() {
        return borrowedBooksService.getAllBorrowedBooks();
    }


    // PUT
    //Uppdatera listan med borrowedbooks
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBorrowedBooks(@PathVariable String id,  @RequestBody BorrowedBooks borrowedBooksDetails) {
        try {
            BorrowedBooks updatedBorrowedBooks = borrowedBooksService.updateBorrowedBooks(id, borrowedBooksDetails);
            return ResponseEntity.ok(updatedBorrowedBooks);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



    // GET by id
    // GET a book using id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BorrowedBooks getBorrowedBooksById(@PathVariable String id) {
        return borrowedBooksService.borrowedBooksById(id);
    }

    // DELETE
    // Delete book
    @RequestMapping(value = "/endLoan/{id}", method = RequestMethod.DELETE)
    public String deleteBorrowedBooks(@PathVariable String id) {
        return borrowedBooksService.deleteBorrowedBooks(id);
    }
}
