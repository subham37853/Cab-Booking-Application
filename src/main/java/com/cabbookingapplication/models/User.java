package com.cabbookingapplication.models;


import com.cabbookingapplication.Contants.Gender;

import java.util.Objects;

public class User {
    private String fullName;
    private String email;
    private Gender gender;
    private int age;
    private Location location;

    public User(String fullName, String email, Gender gender, int age, Location location) {
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.location = location;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return fullName.equals(((User) obj).getFullName()) && email.equals(((User) obj).getEmail());
    }
}
