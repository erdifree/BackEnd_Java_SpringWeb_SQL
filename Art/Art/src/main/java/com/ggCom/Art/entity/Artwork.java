package com.ggCom.Art.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Objects;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "artworks", indexes = {
        @Index(name = "idx_artwork_museum_id", columnList = "museum_id")})
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    //ArtWork-Artist

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id", nullable = false)

    private Artist artist;

    //ArtWork-Character

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artworks", cascade = CascadeType.ALL)
    private Set<Character> characters;

    //AW-M

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "museum_id", nullable = false)
    @JsonBackReference
    private Museum museums;

    public Museum getMuseums() {
        return museums;
    }

    public void setMuseums(Museum museums) {
        this.museums = museums;
    }

    //G&S

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    //CONSTR

    public Artwork(String title) {
        this.title = title;
    }

    public Artwork() {
    }

    //TOSTRING

    @Override
    public String toString() {
        return "Artwork{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist=" + artist + '\'' +
                ", characters=" + characters + '\'' +
                ", museums=" + museums + '\'' +
                '}';
    }
}
