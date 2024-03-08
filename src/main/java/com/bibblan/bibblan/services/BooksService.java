package com.bibblan.bibblan.services;

import com.bibblan.bibblan.dto.books.FindBookDTO;
import com.bibblan.bibblan.dto.books.PostBookDTO;
import com.bibblan.bibblan.dto.books.PutBookDTO;
import com.bibblan.bibblan.models.Books;
import com.bibblan.bibblan.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

    // add a new book
    public ResponseEntity<?> createBooks(PostBookDTO postBookDTO) {
        Books newBook = new Books();
        newBook.setTitle(postBookDTO.getTitle());
        newBook.setAuthor(postBookDTO.getAuthor());
        newBook.setDescription(postBookDTO.getDescription());
        newBook.setPrice(postBookDTO.getPrice());
        newBook.setNumberOfPages(postBookDTO.getNumberOfPages());
        booksRepository.save(newBook);
        return ResponseEntity.ok("Book created");
    }

    // get a list with all books
    public List<Books> getAllBooks() {
        try {
            return booksRepository.findAll();
        }catch (NullPointerException p){
            throw new RuntimeException("Could not find any books");
        }
    }

    // update a books information
    public ResponseEntity<?> updateBooks(PutBookDTO putBookDTO) {
        Books foundBook = booksRepository.findById(putBookDTO.getId())
                .orElseThrow(() -> new RuntimeException("Book does not exist"));
        if (putBookDTO.getTitle() != null) {
            foundBook.setTitle(putBookDTO.getTitle());
        }
        if (putBookDTO.getAuthor() != null) {
            foundBook.setAuthor(putBookDTO.getAuthor());
        }
        if (putBookDTO.getDescription() != null) {
            foundBook.setDescription(putBookDTO.getDescription());
        }
        if (putBookDTO.getPrice() != 0) {
            foundBook.setPrice(putBookDTO.getPrice());
        }
        if (putBookDTO.getNumberOfPages() != 0) {
            foundBook.setNumberOfPages(putBookDTO.getNumberOfPages());
        }
        booksRepository.save(foundBook);
        return ResponseEntity.ok("Book updated!");
    }

    // get a specifik book using id
    public ResponseEntity<?> booksById(FindBookDTO findBookDTO) {
        Books foundBook = booksRepository.findById(findBookDTO.getId())
                .orElseThrow(() -> new RuntimeException("Book does not exist"));
        return ResponseEntity.ok(booksRepository.findById(findBookDTO.getId()));
    }

    // delete book
    public ResponseEntity<?> deleteBooks(FindBookDTO findBookDTO) {
        Books deleteBook = booksRepository.findById(findBookDTO.getId())
                .orElseThrow(() -> new RuntimeException("Book does not exist"));
        booksRepository.delete(deleteBook);
        return ResponseEntity.ok("Book was deleted");
    }

}
