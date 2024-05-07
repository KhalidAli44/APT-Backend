package com.APT.Backend.Web;

import com.APT.Backend.Model.DocumentInfo;
import com.APT.Backend.Model.SharedInfo;
import com.APT.Backend.Services.DocumentService;
import com.APT.Backend.Services.SharedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shared")
public class SharedController {

    @Autowired
    private SharedService sharedService;

    @Autowired
    private DocumentService documentService;

    @GetMapping("/{username}")
    public ResponseEntity<List<DocumentInfo>> getSharedByUsername(@PathVariable String username) {
        List<SharedInfo> shared = sharedService.getSharedByUsername(username);

        List<DocumentInfo> documents = new ArrayList<>();

        for (SharedInfo sharedInfo : shared) {
            String documentId = sharedInfo.getDocumentId();

            Optional<DocumentInfo> documentInfo = documentService.getDocumentById(documentId);

            documentInfo.ifPresent(documents::add);
        }

        return new ResponseEntity<>(documents, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<SharedInfo> shareDocument(@RequestBody SharedInfo sharedInfo) {
        try {
            SharedInfo savedSharedInfo = sharedService.save(sharedInfo);
            return ResponseEntity.ok(savedSharedInfo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

