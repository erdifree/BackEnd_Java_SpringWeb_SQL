package com.ggCom.Art.controller;

import com.ggCom.Art.entity.Artist;
import com.ggCom.Art.entity.Artwork;
import com.ggCom.Art.repository.ArtistRep;
import com.ggCom.Art.repository.ArtworkRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/artworks")
@CrossOrigin
public class AWCon {

    @Autowired
    private ArtworkRep artworkRep;

    @Autowired
    private ArtistRep artistRep;

    @GetMapping
    public List<Artwork> getAll(){
        return artworkRep.findAll();
    }

    @GetMapping ("/{id}")

    public Artist getArtistRep(@PathVariable Integer id) {
        Optional<Artwork> resultArtWork= artworkRep.findById(id);
        if (resultArtWork.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            Artwork newArtWork=resultArtWork.get();
            return newArtWork.getArtist();
        }
    }
}

