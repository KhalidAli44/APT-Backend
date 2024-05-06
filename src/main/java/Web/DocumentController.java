//package Web;
//
//import Model.DocumentInfo;
//import Repositories.DocumentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/documents")
//public class DocumentController {
//
//    @Autowired
//    private DocumentRepository documentRepository;
//
//    @PostMapping
//    public ResponseEntity<DocumentInfo> createDocument(@RequestBody DocumentInfo documentInfo) {
//        DocumentInfo createdDocument = documentRepository.save(documentInfo);
//        return new ResponseEntity<>(createdDocument, HttpStatus.CREATED);
//    }
//}
//
