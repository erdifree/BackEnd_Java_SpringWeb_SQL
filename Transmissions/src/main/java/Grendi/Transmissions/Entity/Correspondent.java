package Grendi.Transmissions.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.awt.*;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table
public class Correspondent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clientCode;
    private String companyName;
    private String vatNumber;
    private String address;
    private String locality;
    private int cap;
    private String referenceItName;
    private String referenceItSurname;
    private String referenceItEmail;
    private String ReferenceItTelephone;
    private TextArea note;
    private Blob file;
    private String server;
    private String port;
    private String usernameCorrespondentServer;
    private String passwordCorrespondentServer;

    @OneToMany(mappedBy = "correspondent")
    @JsonManagedReference
    private Set<CorrespondentDocument> correspondentDocumentSet;
 @JsonIgnore
 @ManyToMany(fetch = FetchType.EAGER)
 @JoinTable(name = "platforms_correspondents",
         joinColumns = @JoinColumn(name = "id_platform", foreignKey = @ForeignKey(name = "FK_correspondents")),
         inverseJoinColumns = @JoinColumn(name = "id_correspondents", foreignKey = @ForeignKey(name = "FK_platform")))
        private Set<Platform> platformSet;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getReferenceItName() {
        return referenceItName;
    }

    public void setReferenceItName(String referenceItName) {
        this.referenceItName = referenceItName;
    }

    public String getReferenceItSurname() {
        return referenceItSurname;
    }

    public void setReferenceItSurname(String referenceItSurname) {
        this.referenceItSurname = referenceItSurname;
    }

    public String getReferenceItEmail() {
        return referenceItEmail;
    }

    public void setReferenceItEmail(String referenceItEmail) {
        this.referenceItEmail = referenceItEmail;
    }

    public String getReferenceItTelephone() {
        return ReferenceItTelephone;
    }

    public void setReferenceItTelephone(String referenceItTelephone) {
        ReferenceItTelephone = referenceItTelephone;
    }

    public TextArea getNote() {
        return note;
    }

    public void setNote(TextArea note) {
        this.note = note;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsernameCorrespondentServer() {
        return usernameCorrespondentServer;
    }

    public void setUsernameCorrespondentServer(String usernameCorrespondentServer) {
        this.usernameCorrespondentServer = usernameCorrespondentServer;
    }

    public String getPasswordCorrespondentServer() {
        return passwordCorrespondentServer;
    }

    public void setPasswordCorrespondentServer(String passwordCorrespondentServer) {
        this.passwordCorrespondentServer = passwordCorrespondentServer;
    }
}
