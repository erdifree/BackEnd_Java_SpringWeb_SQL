package work.group.Call.center.entity;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "telephoneoperators")
public class TelephoneOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;


    private String cityRegOffice;


    private String vatNumber;

    @ManyToMany(mappedBy = "operators", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Subscriber> subscribers;


    public TelephoneOperator() {
    }

    public TelephoneOperator(TelephoneOperator operator) {
        this.name=operator.getName();
        this.cityRegOffice=operator.getCityRegOffice();
        this.vatNumber=operator.getVatNumber();
        this.subscribers=operator.getSubscribers();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityRegOffice() {
        return cityRegOffice;
    }

    public void setCityRegOffice(String cityRegOffice) {
        this.cityRegOffice = cityRegOffice;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
