package com.ggCom.Art.repository;

import com.ggCom.Art.entity.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import java.util.List;

public interface ArtworkRep extends JpaRepository<Artwork, Integer> {

    List<Artwork> findByArtistId(Integer intero);

}
