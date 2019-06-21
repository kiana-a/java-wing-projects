package com.company;

/**
 * Created by kiana on 1/30/18.
 */
public class Owner {
    private String name;
    private String lastName;
    private int nationalId;


    public Owner(String name, String lastName, int nationalId) {
        this.name = name;
        this.lastName = lastName;
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }
}
