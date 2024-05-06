package com.APT.Backend.Web;

import com.APT.Backend.Model.DocumentInfo;
import com.APT.Backend.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
