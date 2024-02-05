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
        return booksRepository.save(books);
    }

    // get a specifik book using id
    public Books booksById(String id) {
        return booksRepository.findById(id).get();
    }

    // delete book
    public String deleteBooks(String id) {
        booksRepository.deleteById(id);
        return "Book with id: " + id + " has been deleted";
    }

}
