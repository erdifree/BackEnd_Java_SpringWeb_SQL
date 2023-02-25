package Grendi.Transmissions.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table
public class CorrespondentDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Blob file;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_correspondent")
    @JsonBackReference
    private Correspondent correspondent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
