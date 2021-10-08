package com.customermanager.enterprise.dto;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer")
public @Data class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country_code")
    private String countryCode;

    public String getAddress() {
        return address + " " + city + ", " + state + " " + countryCode;
    }

    public Customer(Long id, String firstName, String lastName, String email, String address, String city, String state,
            String countryCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.countryCode = countryCode;
    }

    public Customer(String firstName, String lastName, String email, String address, String city, String state,
            String countryCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.countryCode = countryCode;
    }

    public Customer() {
    }

}
