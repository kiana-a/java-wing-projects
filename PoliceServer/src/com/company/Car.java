package com.company;

/**
 * Created by kiana on 1/30/18.
 */
public class Car {

    private String chassisNum;
    private String model;
    private Plaque plaque;
    private Owner owner;
    private Color color;

    public Car(String chassisNum, String model, Plaque plaque, Owner owner, Color color) {
        this.chassisNum = chassisNum;
        this.model = model;
        this.plaque = plaque;
        this.owner = owner;
        this.color = color;
    }

    public Car(String chassisNum, String model, Plaque plaque, Color color) {
        this.chassisNum = chassisNum;
        this.model = model;
        this.plaque = plaque;
        this.color = color;
    }

    public Car(String chassisNum, String model, Color color) {
        this.chassisNum = chassisNum;
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Plaque getPlaque() {
        return plaque;
    }

    public void setPlaque(Plaque plaque) {
        this.plaque = plaque;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getChassisNum() {
        return chassisNum;
    }

    public void setChassisNum(String chassisNum) {
        this.chassisNum = chassisNum;
    }
}
