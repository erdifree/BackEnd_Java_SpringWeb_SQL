package com.ggCom.Art.ServiceDTO;

import com.ggCom.Art.entity.Museum;

public class MuseumDTO {
    private String name;
    private String city;
    private String country;

    public MuseumDTO getMuseumDTO(Museum mus){
        MuseumDTO museumDTO=new MuseumDTO();
        museumDTO.setName(mus.getName());
        museumDTO.setCity(mus.getCity());
        museumDTO.setCountry(mus.getCountry());
        return museumDTO;
    }

    //G&S

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
}
