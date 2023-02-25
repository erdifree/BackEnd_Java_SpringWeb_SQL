package Grendi.Transmissions.Entity;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table
public class ClientDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Blob file;

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
}
