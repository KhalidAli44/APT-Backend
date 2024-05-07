package com.APT.Backend.Services;

import com.APT.Backend.Model.DocumentInfo;
import com.APT.Backend.Repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public DocumentInfo save(DocumentInfo documentInfo) {
        return documentRepository.save(documentInfo);
    }

    public List<DocumentInfo> getDocumentsByAuthor(String author) {
        return documentRepository.findByAuthor(author);
    }

    public Optional<DocumentInfo> getDocumentById(String id) { return documentRepository.findById(id); }

}
