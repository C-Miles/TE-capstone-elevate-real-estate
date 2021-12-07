package com.techelevator.model;

import java.util.Objects;

public class Property {

    private String address;
    private long propertyId;
    private String propertyName;
    private String imageName;
    private int numberOfRooms;
    private double monthlyRent;
    private String apartmentNumber;
    private String city;
    private String state;


    private int zipcode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Property{" +
                "address='" + address + '\'' +
                ", propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", imageName='" + imageName + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", monthlyRent=" + monthlyRent +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return propertyId == property.propertyId && numberOfRooms == property.numberOfRooms &&
                Double.compare(property.monthlyRent, monthlyRent) == 0 && zipcode == property.zipcode && address.equals(property.address)
                && propertyName.equals(property.propertyName) && imageName.equals(property.imageName)
                && apartmentNumber.equals(property.apartmentNumber) && city.equals(property.city) && state.equals(property.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, propertyId, propertyName, imageName, numberOfRooms, monthlyRent, apartmentNumber, city, state, zipcode);
    }
}
