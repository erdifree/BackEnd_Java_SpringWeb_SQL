package com.ggCom.Art.ServiceDTO;
import com.ggCom.Art.entity.Artist;
import com.ggCom.Art.entity.Artwork;
import java.util.ArrayList;
import java.util.List;
    public class ArtistDTO {
        private  int id;
        private  String firstname;
        private  String lastname;
        private  String country;
        private List<ArtWorkDTO> artworkSet;
        public ArtistDTO() {
        }
        public ArtistDTO getArtist(Artist art,List<Artwork> artworkSet){
            ArtistDTO artistDTO= new ArtistDTO();
            List<ArtWorkDTO>result=new ArrayList<>();
            artistDTO.setId(art.getId());
            artistDTO.setFirstname(art.getFirstName());
            artistDTO.setLastname(art.getLastName());
            artistDTO.setCountry(art.getCountry());
            for (int i = 0; i <artworkSet.size() ; i++) {
                ArtWorkDTO a=new ArtWorkDTO();
                MuseumDTO b=new MuseumDTO();
              a.setId(  artworkSet.get(i).getId());
              a.setTitle(  artworkSet.get(i).getTitle());
              a.setCharacters(artworkSet.get(i).getCharacters());
              a.setMus(b.getMuseumDTO(artworkSet.get(i).getMuseums()));
              result.add(a);
            }
            artistDTO.setArtworkSet(result);
            return artistDTO;
        }
        //Get&Set
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getFirstname() {
            return firstname;
        }
        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }
        public String getLastname() {
            return lastname;
        }
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
        public String getCountry() {
            return country;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public List<ArtWorkDTO> getArtworkSet() {
            return artworkSet;
        }
        public void setArtworkSet(List<ArtWorkDTO> artworkSet) {
            this.artworkSet = artworkSet;
        }
        @Override
        public String toString() {
            return "ArtistDTO{" +
                    "id=" + id +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", country='" + country + '\'' +
                    ", artworkSet=" + artworkSet +
                    '}';
        }
    }

