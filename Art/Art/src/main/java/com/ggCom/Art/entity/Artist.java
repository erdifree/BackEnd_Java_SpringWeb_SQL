package com.ggCom.Art.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "artists")

public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String country;

    //Artist-ArtWork

   // @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Artwork> artworks;


    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(Set<Artwork> artworks) {
        this.artworks = artworks;
    }

    //CONSTRUCTOR
    public Artist(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public Artist() {
    }

    //TOSTRING

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", artworks=" + artworks +
                '}';
    }
}
