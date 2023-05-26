package com.example.DeepThought.repository;

import com.example.DeepThought.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends MongoRepository<Event,Integer> {

}
