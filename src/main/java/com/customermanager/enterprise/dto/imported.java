package com.customermanager.enterprise.dto;


import com.google.gson.annotations.SerializedName;

public class imported {

    @SerializedName("firstname")
    private String firstname;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("email")
    private String email;
    @SerializedName("status")
    private String status;
    @SerializedName("assignee")
    private String assignee;
    @SerializedName("id")
    private Integer id;

}