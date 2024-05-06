package com.APT.Backend;

import com.APT.Backend.DocumentInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<DocumentInfo, String> {
    // You can define custom query methods here if needed
}

