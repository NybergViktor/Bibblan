package com.bibblan.bibblan.repository;

import com.bibblan.bibblan.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {

}
