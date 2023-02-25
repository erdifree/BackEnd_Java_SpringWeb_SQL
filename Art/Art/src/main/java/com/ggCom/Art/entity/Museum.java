package com.ggCom.Art.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "museums")
public class Museum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String country;

    private String img;

    //@JsonIgnore
   @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "museums", cascade = CascadeType.ALL)
    private Set<Artwork> artworks;

    //Get&Set

    public Set<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(Set<Artwork> artworks) {
        this.artworks = artworks;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //COSTR
    public Museum(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Museum() {
    }

    @Override
    public String toString() {
        return "Museum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", artworks=" + artworks +
                '}';
    }
}
