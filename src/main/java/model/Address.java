package model;

public class Address {

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

    public Address(String postalCode, String roadNumber, String roadName, String city) {
        this.postalCode = postalCode;
        this.roadNumber = roadNumber;
        this.roadName = roadName;
        this.city = city;
    }
}
