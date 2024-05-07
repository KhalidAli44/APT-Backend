package com.APT.Backend.Services;

import com.APT.Backend.Model.SharedInfo;
import com.APT.Backend.Repositories.SharedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SharedService {
    @Autowired
    private SharedRepository sharedRepository;

    public SharedInfo save(SharedInfo sharedInfo) {
        return sharedRepository.save(sharedInfo);
    }

    public List<SharedInfo> getSharedByUsername(String username) {
        return sharedRepository.findByUsername(username);
    }

    public List<SharedInfo> getSharedByDocumentId(String documentId) {
        return sharedRepository.findByDocumentId(documentId);
    }

    public Optional<SharedInfo> getSharedDocumentById(String id) {
        return sharedRepository.findById(id);
    }

    public SharedInfo saveSharedDocument(SharedInfo sharedInfo) {
        return sharedRepository.save(sharedInfo);
    }

}
