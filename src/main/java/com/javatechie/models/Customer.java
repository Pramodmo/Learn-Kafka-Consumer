package com.javatechie.models;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
    private String contactNo;

    public Customer() {
    }

    public Customer(int id, String contactNo, String email, String name) {
        this.id = id;
        this.contactNo = contactNo;
        this.email = email;
        this.name = name;
    }
}
