package com.customermanager.enterprise.dto;

import javax.persistence.*;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Entity
@Table(name = "customer")
public @Data class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SerializedName("id")
    private Long id;
    @SerializedName("firstName")
    @Column(name = "first_name")
    private String firstName;
    @SerializedName("lastName")
    @Column(name = "last_name")
    private String lastName;
    @SerializedName("email")
    @Column(name = "email")
    private String email;
    @SerializedName("address")
    @Column(name = "address")
    private String address;
    @SerializedName("city")
    @Column(name = "city")
    private String city;
    @SerializedName("state")
    @Column(name = "state")
    private String state;
    @SerializedName("countryCode")
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
