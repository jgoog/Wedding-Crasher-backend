package com.example.weddingcrasher.weddingcrasherback.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Entity
@Table(name = "guestlist")


public class GuestList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;


    @Column
    private String firstName;

    @Column
    private String lastName;

    @JsonIgnore
    @OneToOne(mappedBy = "guestList")
    private WeddingGuest weddingGuest;


    public GuestList() {
    }

    public GuestList(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public WeddingGuest getWeddingGuest() {
        return weddingGuest;
    }

    public void setWeddingGuest(WeddingGuest weddingGuest) {
        this.weddingGuest = weddingGuest;
    }

    @Override
    public String toString() {
        return "GuestList{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
