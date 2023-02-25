package com.ggCom.Art.controller;

import com.ggCom.Art.entity.Character;
import com.ggCom.Art.repository.ChRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
@CrossOrigin
public class ChCon {

    @Autowired
    private ChRep chRep;

    @GetMapping
    public List<Character> getAll(){
        return chRep.findAll();
    }

}


