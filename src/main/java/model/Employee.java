package model;

import java.util.Date;

public class Employee extends  Entity {

    private String cinNumber;
    private String name;
    private String lastname;
    private String phoneNumber;

    public String getCinNumber() {
        return cinNumber;
    }

    public void setCinNumber(String cinNumber) {
        this.cinNumber = cinNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
