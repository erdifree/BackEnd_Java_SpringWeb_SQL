package com.ggCom.Art.repository;

import com.ggCom.Art.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

public interface ArtistRep extends JpaRepository<Artist, Integer> {

}


