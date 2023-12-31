package com.display.consumer.domain.repository.mongo;

import com.display.consumer.domain.document.DisplayStore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisplayStoreRepository extends MongoRepository<DisplayStore, Long> {
}
