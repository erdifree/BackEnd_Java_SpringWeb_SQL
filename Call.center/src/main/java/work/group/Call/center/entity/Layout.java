package work.group.Call.center.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "layout")
public class Layout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String chiave;


    private String valore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChiave() {
        return chiave;
    }

    public void setChiave(String chiave) {
        this.chiave = chiave;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }
}
