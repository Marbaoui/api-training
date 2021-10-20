package com.springboot.todoapi.repository;

import com.springboot.todoapi.models.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<AppUser, String > {
    AppUser findByEmail(String username);
}
