package com.ggCom.Art.ServiceDTO;

import com.ggCom.Art.entity.Artwork;
import com.ggCom.Art.entity.Character;

import java.util.Set;

public class ArtWorkDTO {

    private  int id;
    private  String title;
    private Set<Character>characters;
    private MuseumDTO mus;
    public ArtWorkDTO getArtworkDTO(Artwork artwork){
        ArtWorkDTO newArtworkDTO = new ArtWorkDTO();
        MuseumDTO musDTO=new MuseumDTO();
        newArtworkDTO.setId(artwork.getId());
        newArtworkDTO.setTitle(artwork.getTitle());
        newArtworkDTO.setCharacters(artwork.getCharacters());
        newArtworkDTO.setMus( musDTO.getMuseumDTO(artwork.getMuseums()));
        return newArtworkDTO;
    }




    // G&S


    public MuseumDTO getMus() {
        return mus;
    }

    public void setMus(MuseumDTO mus) {
        this.mus = mus;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> chara) {
        this.characters =chara;
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


}
