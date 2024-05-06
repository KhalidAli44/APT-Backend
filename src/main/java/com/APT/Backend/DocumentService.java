package com.APT.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    @Autowired
    private DocumentService documentRepository;

    public DocumentInfo save(DocumentInfo documentInfo) {
        return documentRepository.save(documentInfo);
    }

}
