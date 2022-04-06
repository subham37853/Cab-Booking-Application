package com.cabbookingapplication.models;


import com.cabbookingapplication.Contants.Gender;

public class Driver extends User {
    private Vehicle vehicleDetails;
    private boolean isAvailable = true;
    private double rate;
    private double totalEarning;

    public Driver(String fullName, String email, Gender gender, int age, String vehicleName,
                  String plateNumber, double rate, int locationX, int locationY) {
        super(fullName, email, gender, age, new Location(locationX, locationY));
        this.vehicleDetails = new Vehicle(vehicleName, plateNumber);
        this.rate = rate;
    }

    public Vehicle getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(Vehicle vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTotalEarning() {
        return totalEarning;
    }

    public void setTotalEarning(double totalEarning) {
        this.totalEarning += totalEarning;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "vehicleDetails=" + vehicleDetails +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
