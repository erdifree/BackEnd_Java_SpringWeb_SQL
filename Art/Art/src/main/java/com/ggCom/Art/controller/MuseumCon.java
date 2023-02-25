package com.ggCom.Art.controller;

import com.ggCom.Art.entity.Museum;
import com.ggCom.Art.repository.MuseumRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/museums")
@CrossOrigin
public class MuseumCon {

    @Autowired
    private MuseumRep museumRep;

    @GetMapping
    public List<Museum> getall() {
        return museumRep.findAll();
    }

    @GetMapping("/mus")
    public List<Museum> getAlloper(@RequestParam(name = "keyword", required = false) String str) {
        List<Museum> m = museumRep.findByNameEqualsIgnoreCase(str);
        return m;
    }

    @GetMapping("/{id}")
    public Museum getById(@PathVariable Integer id){
        Optional<Museum>response=museumRep.findById(id);
        if (response.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Questo museo" + id + "non esiste");
        } else{
            return  response.get();
        }
    }

    @PostMapping("/newmus") // create
    public Museum createMus(@RequestBody Museum museum) {
        return museumRep.save(museum);
    }

    @PutMapping("/{id}/update")
    public Museum updtateGetById(@RequestBody Museum museum, @PathVariable Integer id) {
        Optional<Museum> resultMuseum = museumRep.findById(id);
        if (resultMuseum.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Questo museo" + id + "non esiste");
        } else {
            if (museum.getId() != id) {
                throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
            } else {
                museum.setId(id);
                return museumRep.save(museum);
            }
        }
    }

    @DeleteMapping("/{id}")
    public Boolean deleteMuseum(@PathVariable Integer id) {
        Optional<Museum> result = museumRep.findById(id);
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            museumRep.delete(result.get());
            return true;
        }
    }
}
