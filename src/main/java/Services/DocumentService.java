package Services;

import Model.DocumentInfo;
import Model.UserInfo;
import Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentService documentRepository;

    public DocumentInfo save(DocumentInfo documentInfo) {
        return documentRepository.save(documentInfo);
    }

}
