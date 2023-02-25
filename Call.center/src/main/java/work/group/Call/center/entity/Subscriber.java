package work.group.Call.center.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "subscribers")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "firstname")
    private String firstname;
    @Column (name = "lastname")
    private String lastname;

    private LocalDate dob;
    @Column (name = "cityofbirth")
    private String cityofbirth;
    private double cretid;

    public Subscriber() {}

    @JsonManagedReference
    @OneToMany( mappedBy = "id_sub",cascade = CascadeType.ALL)
    private Set<PhoneCall> phoneCallSet;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "subscribers_operators",
            joinColumns = @JoinColumn(name = "id_telephone_operators", foreignKey = @ForeignKey(name = "FK_operators_subscribers")),
            inverseJoinColumns = @JoinColumn(name = "id_subscribers", foreignKey = @ForeignKey(name = "FK_subscribers_operators")))
    private Set<TelephoneOperator> operators;


    public Set<TelephoneOperator> getOperators() {
        return operators;
    }

    public void setOperators(Set<TelephoneOperator> operators) {
        this.operators = operators;
    }

    public Subscriber(Subscriber sub) {
        this.firstname = sub.getFirstname();
        this.lastname = sub.getLastname();
        this.dob = sub.getDob();
        this.cityofbirth = sub.getCityofbirth();
        this.cretid = sub.getCretid();
        this.phoneCallSet=sub.getPhoneCallSet();
        this.operators=sub.getOperators();
    }


    public Set<PhoneCall> getPhoneCallSet() {
        return phoneCallSet;
    }

    public void setPhoneCallSet(Set<PhoneCall> phoneCallSet) {
        this.phoneCallSet = phoneCallSet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setCityofbirth(String cityofbirth) {
        this.cityofbirth = cityofbirth;
    }

    public void setCretid(double cretid) {
        this.cretid = cretid;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getCityofbirth() {
        return cityofbirth;
    }

    public double getCretid() {
        return cretid;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob=" + dob +
                ", cityofbirth='" + cityofbirth + '\'' +
                ", cretid=" + cretid +
                '}';
    }
}