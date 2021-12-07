package com.techelevator.model;

import java.util.Objects;

public class Property {

    private String address;
    private long propertyId;
    private String propertyName;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return propertyId == property.propertyId && numberOfRooms == property.numberOfRooms &&
                Double.compare(property.monthlyRent, monthlyRent) == 0 && zipcode == property.zipcode &&
                Objects.equals(propertyName, property.propertyName) &&
                Objects.equals(apartmentNumber, property.apartmentNumber) && Objects.equals(city, property.city) && Objects.equals(state, property.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyName, numberOfRooms, monthlyRent, apartmentNumber, city, state, zipcode);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
