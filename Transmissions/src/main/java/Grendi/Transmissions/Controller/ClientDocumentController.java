package Grendi.Transmissions.Controller;

import Grendi.Transmissions.Entity.ClientDocument;
import Grendi.Transmissions.Repository.ClientDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/clienti/documenti")
public class ClientDocumentController {

    @Autowired
    ClientDocumentRepository clientDocumentRepository;


    @GetMapping
    public List<ClientDocument> getAll(){
        List<ClientDocument> response= clientDocumentRepository.findAll();
        return response;
    }


}
