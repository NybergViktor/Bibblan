package com.bibblan.bibblan.services;

import com.bibblan.bibblan.models.Books;
import com.bibblan.bibblan.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

    // add a new book
    public Books createBooks(Books books) {
        return booksRepository.save(books);
    }

    // get a list with all books
    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    // update a books information
    public Books updateBooks(Books books) {
        Books newBook = booksRepository.findById(books.getId())
                .orElseThrow(() -> new RuntimeException("BookId does not exist"));
        return booksRepository.save(books);
    }

    // get a specifik book using id
    public Books booksById(Books books) {
        Books newBook = booksRepository.findById(books.getId())
                .orElseThrow(() -> new RuntimeException("BookId does not exist"));
        return booksRepository.findById(books.getId()).get();
    }

    // delete book
    public String deleteBooks(Books books) {
        Books newBook = booksRepository.findById(books.getId())
                .orElseThrow(() -> new RuntimeException("BookId does not exist"));
        booksRepository.deleteById(books.getId());
        return "Book with id: " + books.getTitle() + " has been deleted";
    }

}
