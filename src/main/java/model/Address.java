package model;

import dao.HasId;

public class Address implements HasId {

    private String id;
    private String postalCode;
    private String roadNumber;
    private String roadName;
    private String city;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRoadNumber() {
        return roadNumber;
    }

    public void setRoadNumber(String roadNumber) {
        this.roadNumber = roadNumber;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
