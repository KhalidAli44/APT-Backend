package com.APT.Backend.Repositories;

import com.APT.Backend.Model.DocumentInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DocumentRepository extends MongoRepository<DocumentInfo, String> {
    List<DocumentInfo> findByAuthor(String author);
}

