package com.company;

import java.util.Date;

/**
 * Created by kiana on 1/30/18.
 */
public class Plaque {
    private Car car;
    private int plaqueNum;
    private Owner owner;
    private Date createdAt;
    private Date deletedAt;

    public Plaque(int chassisNum, Car car, int plaqueNum, Owner owner) {
        this.car = car;
        this.plaqueNum = plaqueNum;
        this.owner = owner;
        this.createdAt = new Date();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getPlaqueNum() {
        return plaqueNum;
    }

    public void setPlaqueNum(int plaqueNum) {
        this.plaqueNum = plaqueNum;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
