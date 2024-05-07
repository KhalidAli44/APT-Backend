package com.APT.Backend.Repositories;

import com.APT.Backend.Model.SharedInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SharedRepository extends MongoRepository<SharedInfo, String> {
    List<SharedInfo> findByUsername(String username);
    List<SharedInfo> findByDocumentId(String documentId);
}

