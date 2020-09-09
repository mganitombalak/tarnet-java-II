package com.tarnet.entity;

public class Farmer {

    public String firstName;
    public String lastName;
    public boolean IsEligibleForCredit;
    public double creditLimit;

    public Farmer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
