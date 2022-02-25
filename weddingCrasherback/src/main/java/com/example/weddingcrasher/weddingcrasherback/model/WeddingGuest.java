package com.example.weddingcrasher.weddingcrasherback.model;


import javax.persistence.*;

@Entity
@Table(name = "guest")


public class WeddingGuest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    @Column(unique = true)
    private String emailAddress;

    @OneToOne
    @JoinColumn(name = "guestlist_id", referencedColumnName = "id")
    private GuestList guestList;

    public WeddingGuest() {
    }

    public WeddingGuest(Long id, String lastName, String firstName, String emailAddress) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "WeddingGuest{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + emailAddress + '\'' +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
