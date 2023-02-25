package Grendi.Transmissions.Controller;

import Grendi.Transmissions.Entity.Client;
import Grendi.Transmissions.Entity.ClientDocument;
import Grendi.Transmissions.Repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public Set<Client> getAll(){
      return (Set<Client>) clientRepository.findAll();

    }


    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ClientDocument uploadFile(@RequestParam MultipartFile file) {
        logger.info(String.format("File name '%s' uploaded successfully.", file.getOriginalFilename()));
        return ClientDocument.ok().build();
    }
}

}
