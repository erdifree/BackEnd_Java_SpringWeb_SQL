package work.group.Call.center.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "phonecalls")
public class PhoneCall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime start;
    private LocalDateTime end;
    private double rate;
    // private double priceCallPhone;

   /* public double getPriceCallPhone() {
        Duration d = Duration.between(start,end);
        return rate * d.getSeconds();
    }

    public void setPriceCallPhone(double priceCallPhone) {
        this.priceCallPhone = priceCallPhone;
    }*/

    @JsonBackReference
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sub")
    private Subscriber id_sub;


    public Subscriber getId_sub() {
        return id_sub;
    }

    public void setId_sub(Subscriber id_sub) {
        this.id_sub = id_sub;
    }

    public double getRate() {

        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public PhoneCall() {
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }




    @Override
    public String toString() {
        return "PhoneCall{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", rate=" + rate +
                ", id_sub=" + id_sub +
                '}';
    }
}
