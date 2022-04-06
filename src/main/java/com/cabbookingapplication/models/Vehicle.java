package com.cabbookingapplication.models;

public class Vehicle {
    private String name;
    private String platNumber;

    public Vehicle(String name, String platNumber) {
        this.name = name;
        this.platNumber = platNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatNumber() {
        return platNumber;
    }

    public void setPlatNumber(String platNumber) {
        this.platNumber = platNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", platNumber='" + platNumber + '\'' +
                '}';
    }
}
