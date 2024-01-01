package com.example.mvcstoredisplay.domain.repository;

import com.example.mvcstoredisplay.domain.document.DisplayStore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisplayStoreRepository extends MongoRepository<DisplayStore, Long> {
}
