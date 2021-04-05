package model;

import java.io.Serializable;
import java.util.Date;

public class Entity  implements Serializable {

    protected String id;
    protected String name;
    protected String lastname;
    protected String fatherName;
    protected Address address;
    protected Date birthday;
    protected String imageSource;

    public Entity(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Entity(String name, String lastname, String fatherName, Address address, Date birthday, String imageSource, String id) {
        this.name = name;
        this.lastname = lastname;
        this.fatherName = fatherName;
        this.address = address;
        this.birthday = birthday;
        this.imageSource = imageSource;
        this.id = id;
    }
}
