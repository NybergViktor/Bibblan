package com.bibblan.bibblan.repository;

import com.bibblan.bibblan.models.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BooksRepository extends MongoRepository<Books, String> {
}
