package com.bibblan.bibblan.controllers;

import com.bibblan.bibblan.dto.BB.FindBBDTO;
import com.bibblan.bibblan.dto.BB.PostBBDTO;
import com.bibblan.bibblan.dto.BB.PutBBDTO;
import com.bibblan.bibblan.exception.EntityNotFoundException;
import com.bibblan.bibblan.models.BorrowedBooks;
import com.bibblan.bibblan.services.BorrowedBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/borrowedbooks")
public class BorrowedBooksController {
    @Autowired
    BorrowedBooksService borrowedBooksService;


    // POST
    //, skapar en ny lista med lånade böcker med hjälp av constructor i BorrowedBooks
    @PostMapping()
    public ResponseEntity<?> addBorrowedBooks(@RequestBody PostBBDTO postBBDTO) {
        try {
            return ResponseEntity.ok(borrowedBooksService.addBorrowedBooks(postBBDTO));

        } catch (EntityNotFoundException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }


    // GET
    // GET all borrowedBooks
    @GetMapping("/all")
    public List<BorrowedBooks> getAllBorrowedBooks() {

          return  borrowedBooksService.getAllBorrowedBooks();


    }


    // PUT
    //Uppdatera listan med borrowedbooks
    @PutMapping()
    public ResponseEntity<?> updateBorrowedBooks(@RequestBody PutBBDTO putBBDTO) {
        try {
            BorrowedBooks updatedBorrowedBooks = borrowedBooksService.updateBorrowedBooks(putBBDTO);
            return ResponseEntity.ok(updatedBorrowedBooks);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



    // GET by id
    // GET a borrowedBooks list using id

    @GetMapping("/find")
    public ResponseEntity<?> getBorrowedBooksById(@RequestBody FindBBDTO findBBDTO) {

        try {
            return borrowedBooksService.borrowedBooksById(findBBDTO);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    // DELETE
    // Delete book from borrowedBooks
    @DeleteMapping( "/endLoan")
    public ResponseEntity<?> deleteBorrowedBooks(@RequestBody FindBBDTO findBBDTO) {
        try {
            return borrowedBooksService.deleteBorrowedBooks(findBBDTO);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
