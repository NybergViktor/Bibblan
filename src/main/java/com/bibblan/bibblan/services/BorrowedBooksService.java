package com.bibblan.bibblan.services;

import com.bibblan.bibblan.repository.BorrowedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowedBooksService {
    @Autowired
    BorrowedBooksRepository borrowedBooksRepository;
}
