package com.example.DeepThought.repository;

import com.example.DeepThought.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<User,Integer> {

}
