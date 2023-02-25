package Grendi.Transmissions.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sitePlatform;
    private String addressPlatform;
    private String localityPlatform;
    private int capPlatform;


  @ManyToMany(mappedBy = "platforms")
   private Set<Client> clients;

    @ManyToMany(mappedBy = "platformSet")
    private Set<Correspondent> correspondents;

  @OneToMany(mappedBy = "platform")
  @JsonManagedReference
  private Set<PracticeDocument> practiceDocuments;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSitePlatform() {
        return sitePlatform;
    }

    public void setSitePlatform(String sitePlatform) {
        this.sitePlatform = sitePlatform;
    }

    public String getAddressPlatform() {
        return addressPlatform;
    }

    public void setAddressPlatform(String addressPlatform) {
        this.addressPlatform = addressPlatform;
    }

    public String getLocalityPlatform() {
        return localityPlatform;
    }

    public void setLocalityPlatform(String localityPlatform) {
        this.localityPlatform = localityPlatform;
    }

    public int getCapPlatform() {
        return capPlatform;
    }

    public void setCapPlatform(int capPlatform) {
        this.capPlatform = capPlatform;
    }
}
