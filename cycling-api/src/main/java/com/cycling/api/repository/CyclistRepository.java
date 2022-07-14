package com.cycling.api.repository;

import com.cycling.api.collection.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclistRepository extends ReactiveMongoRepository<Cyclist, String> {
}
