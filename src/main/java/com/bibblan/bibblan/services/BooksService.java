package com.bibblan.bibblan.services;

import com.bibblan.bibblan.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

}
