package com.bibblan.bibblan.services;

import com.bibblan.bibblan.dto.BB.FindBBDTO;
import com.bibblan.bibblan.dto.BB.PostBBDTO;
import com.bibblan.bibblan.dto.BB.PutBBDTO;
import com.bibblan.bibblan.models.BorrowedBooks;
import com.bibblan.bibblan.models.Users;
import com.bibblan.bibblan.repository.BooksRepository;
import com.bibblan.bibblan.repository.BorrowedBooksRepository;
import com.bibblan.bibblan.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBooksService {
    @Autowired
    BorrowedBooksRepository borrowedBooksRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    BooksRepository booksRepository;

    // skapa en lista med borrowedBooks
    public BorrowedBooks addBorrowedBooks(PostBBDTO postBBDTO) {

        Users foundUser = usersRepository.findById(postBBDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Couldn't find user."));
        BorrowedBooks borrowedBooks = new BorrowedBooks();
        borrowedBooks.setUserId(foundUser);
        borrowedBooks.setBookList(postBBDTO.getBookList());


        return borrowedBooksRepository.save(borrowedBooks);
    }



    // get a list with all BorrowedBooks
    public List<BorrowedBooks> getAllBorrowedBooks() {
        try {
            return borrowedBooksRepository.findAll();
        } catch (NullPointerException p){
            throw new RuntimeException("Could not find any BorrowedBooks");
        }
    }

    // update a BorrowedBooks
    public BorrowedBooks updateBorrowedBooks(PutBBDTO putBBDTO) {
        BorrowedBooks borrowedBooks = borrowedBooksRepository.findById(putBBDTO.getId()).get();
        borrowedBooks.setUserId(usersRepository.findById(putBBDTO.getUserId()).get());
        borrowedBooks.setBookList(putBBDTO.getBookList());
        return borrowedBooksRepository.save(borrowedBooks);
    }

    // get a specifik BorrowedBooks using id
    public ResponseEntity<?> borrowedBooksById(FindBBDTO findBBDTO) {
        BorrowedBooks foundBorrowedBooks = borrowedBooksRepository.findById(findBBDTO.getId())
                .orElseThrow(() -> new RuntimeException("List does not exist"));
        return ResponseEntity.ok(foundBorrowedBooks);
    }

    // delete BorrowedBooks
    public ResponseEntity<?> deleteBorrowedBooks(FindBBDTO findBBDTO) {
        BorrowedBooks foundBorrowedBooks = borrowedBooksRepository.findById(findBBDTO.getId())
                .orElseThrow(() -> new RuntimeException("List does not exist"));
        borrowedBooksRepository.delete(foundBorrowedBooks);
        return ResponseEntity.ok("List was deleted.");
    }


}
