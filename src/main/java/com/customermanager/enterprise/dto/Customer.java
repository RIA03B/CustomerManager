package com.customermanager.enterprise.dto;

import javax.persistence.*;

import lombok.Data;

/**
 * This is the Model Layer This class is representing the data that can be
 * persisted to the database. Every instance represents a row in the table that
 * is being stored in the database. The table name is customer, and it holds
 * first & last name, email, address, city, state, and country.
 * 
 * @author Rania Ibrahim, Christian Turner, Elijah Klopfstein
 */
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

    public String getFullAddress() {
        return address + " " + city + ", " + state + " " + countryCode;
    }
}