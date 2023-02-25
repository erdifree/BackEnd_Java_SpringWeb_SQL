package work.group.Call.center.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import work.group.Call.center.entity.Colors;
import work.group.Call.center.repository.ColorRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/ap1/colors")
@CrossOrigin
public class ColorsController {

    @Autowired
    ColorRepository colorRepository;


    @GetMapping
    public List<Colors> getAll(){
        List<Colors> response= colorRepository.findAll();
        if (response.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
           return response;
        }
    }
}
