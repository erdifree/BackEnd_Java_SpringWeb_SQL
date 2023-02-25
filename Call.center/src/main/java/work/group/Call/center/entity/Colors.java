package work.group.Call.center.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "colors")
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  colorName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
