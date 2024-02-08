package com.bibblan.bibblan.services;

import com.bibblan.bibblan.models.BorrowedBooks;
import com.bibblan.bibblan.repository.BorrowedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBooksService {
    @Autowired
    BorrowedBooksRepository borrowedBooksRepository;

    // add a new list of borrowed books
    public BorrowedBooks createBorrowedBooks(BorrowedBooks borrowedBooks) {
        return borrowedBooksRepository.save(borrowedBooks);
    }

    // get a list with all BorrowedBooks
    public List<BorrowedBooks> getAllBorrowedBooks() {
        return borrowedBooksRepository.findAll();
    }

    // update a BorrowedBooks returningDate
    public BorrowedBooks updateBorrowedBooks(BorrowedBooks borrowedBooks) {
        return borrowedBooksRepository.save(borrowedBooks);
    }

    // get a specifik BorrowedBooks using id
    public BorrowedBooks borrowedBooksById(String id) {
        return borrowedBooksRepository.findById(id).get();
    }

    // delete BorrowedBooks
    public String deleteBorrowedBooks(String id) {
        borrowedBooksRepository.deleteById(id);
        return "User with id: " + id + " has been deleted";
    }

}
