package com.APT.Backend.Web;

import com.APT.Backend.Model.DocumentInfo;
import com.APT.Backend.Model.SharedInfo;
import com.APT.Backend.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public ResponseEntity<DocumentInfo> createDocument(@RequestBody DocumentInfo documentInfo) {
        DocumentInfo createdDocument = documentService.save(documentInfo);
        return new ResponseEntity<>(createdDocument, HttpStatus.CREATED);
    }

    @GetMapping("/{documentId}")
    public ResponseEntity<String> getDocumentContentById(@PathVariable String documentId) {
        Optional<DocumentInfo> documentOptional = documentService.findById(documentId);

        if (documentOptional.isPresent()) {
            String content = documentOptional.get().getContent();
            return ResponseEntity.ok(content);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{author}")
    public ResponseEntity<List<DocumentInfo>> getDocumentsByAuthor(@PathVariable String author) {
        List<DocumentInfo> documents = documentService.getDocumentsByAuthor(author);
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable String id) {
        try {
            documentService.deleteDocument(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting document");
        }
    }

    @PutMapping("/rename/{id}")
    public ResponseEntity<DocumentInfo> renameDocument(@PathVariable String id, @RequestBody DocumentInfo updatedDocumentInfo) {
        Optional<DocumentInfo> existingDocumentOptional = documentService.getDocumentById(id);

        if (existingDocumentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        DocumentInfo existingDocument = existingDocumentOptional.get();

        existingDocument.setFilename(updatedDocumentInfo.getFilename());

        DocumentInfo savedDocument = documentService.save(existingDocument);

        return ResponseEntity.ok(savedDocument);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DocumentInfo> updateDocumentContent(@PathVariable String id, @RequestBody DocumentInfo updatedDocumentInfo) {
        Optional<DocumentInfo> documentOptional = documentService.findById(id);
        if (documentOptional.isPresent()) {
            DocumentInfo existingDocument = documentOptional.get();
            existingDocument.setContent(updatedDocumentInfo.getContent());
            DocumentInfo savedDocument = documentService.save(existingDocument);
            return ResponseEntity.ok(savedDocument);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

