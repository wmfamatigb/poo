package model;

import java.io.Serializable;
import java.util.Date;

public class Student  extends Entity  {

    private String motherName;
    private String grandFatherName;
    private String fatherCin;
    private String fatherPhoneNumber;

    public Student(String name, String lastname, String fatherName, Address address, Date birthday, String imageSource, String id, String motherName, String grandFatherName, String fatherCin, String fatherPhoneNumber) {
        super(name, lastname, fatherName, address, birthday, imageSource, id);
        this.motherName = motherName;
        this.grandFatherName = grandFatherName;
        this.fatherCin = fatherCin;
        this.fatherPhoneNumber = fatherPhoneNumber;

    }

    public Student(){
        super();
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setGrandFatherName(String grandFatherName) {
        this.grandFatherName = grandFatherName;
    }

    public void setFatherCin(String fatherCin) {
        this.fatherCin = fatherCin;
    }

    public void setFatherPhoneNumber(String fatherPhoneNumber) {
        this.fatherPhoneNumber = fatherPhoneNumber;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getGrandFatherName() {
        return grandFatherName;
    }

    public String getFatherCin() {
        return fatherCin;
    }

    public String getFatherPhoneNumber() {
        return fatherPhoneNumber;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", address=" + address +
                ", birthday=" + birthday +
                ", imageSource='" + imageSource + '\'' +
                ", motherName='" + motherName + '\'' +
                ", grandFatherName='" + grandFatherName + '\'' +
                ", fatherCin='" + fatherCin + '\'' +
                ", fatherPhoneNumber='" + fatherPhoneNumber + '\'' +
                '}';
    }

}


