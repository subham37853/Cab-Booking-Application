package com.cabbookingapplication.models;


import com.cabbookingapplication.Contants.Gender;

public class Passenger extends User {
    public Passenger(String fullName, String email, Gender gender, int age, int x, int y) {
        super(fullName, email, gender, age, new Location(x, y));
    }
}
