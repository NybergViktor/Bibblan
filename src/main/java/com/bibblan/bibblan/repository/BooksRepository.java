package com.bibblan.bibblan.repository;

import com.bibblan.bibblan.models.Books;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends MongoRepository<Books, String> {
}
