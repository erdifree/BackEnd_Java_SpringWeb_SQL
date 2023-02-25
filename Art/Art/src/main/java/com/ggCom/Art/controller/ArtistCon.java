package com.ggCom.Art.controller;

import com.ggCom.Art.ServiceDTO.ArtistDTO;
import com.ggCom.Art.entity.Artist;
import com.ggCom.Art.entity.Artwork;
import com.ggCom.Art.repository.ArtistRep;
import com.ggCom.Art.repository.ArtworkRep;
import com.ggCom.Art.repository.MuseumRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/artists")
@CrossOrigin
public class ArtistCon {

    @Autowired
    private ArtistRep artistRep;

    @Autowired
    private ArtworkRep artworkRep;

    @Autowired
    private MuseumRep museumRep;

    @GetMapping
    public List<Artist> getAll(){
        return artistRep.findAll();
    }

    @GetMapping("/{id}")
    public ArtistDTO getArtist(@PathVariable Integer id){
        ArtistDTO artistDTO=new ArtistDTO();
        List<Artwork> resultArtwirk=artworkRep.findByArtistId(id);
        if (resultArtwirk.isEmpty()){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            Optional<Artist> resultArtist=artistRep.findById(id);
            if (resultArtist.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }else {
                return   artistDTO.getArtist( resultArtist.get(),resultArtwirk);
            }
        }
    }
}


