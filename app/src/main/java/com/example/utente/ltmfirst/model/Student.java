package com.example.utente.ltmfirst.model;

/**
 * Created by Utente on 15/02/2017.
 */

public class Student {
    String name;
    String address;
    String email;
    String course;
    String birthDay;
    String phone;

    public String getName() {
        return name;
    }

    public Student(String name, String phone, String address, String email, String course, String birthDay) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.email = email;
        this.course = course;
        this.birthDay = birthDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
