package Grendi.Transmissions.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.awt.*;
import java.sql.Blob;

@Entity
@Table
public class PracticeDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     private String nameSupplier;
     private String  title;
     private TextArea  description;
     private boolean complited;
     private Blob file;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_practice_document")
    @JsonBackReference
     private Platform platform;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TextArea getDescription() {
        return description;
    }

    public void setDescription(TextArea description) {
        this.description = description;
    }

    public boolean isComplited() {
        return complited;
    }

    public void setComplited(boolean complited) {
        this.complited = complited;
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
