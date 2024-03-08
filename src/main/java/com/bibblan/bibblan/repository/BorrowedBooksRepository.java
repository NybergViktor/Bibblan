package com.bibblan.bibblan.repository;

import com.bibblan.bibblan.models.BorrowedBooks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedBooksRepository extends MongoRepository<BorrowedBooks, String> {


}
