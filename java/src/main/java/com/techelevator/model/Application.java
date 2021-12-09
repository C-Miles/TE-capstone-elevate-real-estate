package com.techelevator.model;

import java.util.Objects;

public class Application {

private long rentAppId;
private String firstName;
private String lastName;
private String emailAddress;
private String phoneNumber;
private String appStatus;
private int unitId;

    public long getRentAppId() {
        return rentAppId;
    }

    public void setRentAppId(long rentAppId) {
        this.rentAppId = rentAppId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return rentAppId == that.rentAppId && unitId == that.unitId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(appStatus, that.appStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentAppId, firstName, lastName, emailAddress, phoneNumber, appStatus, unitId);
    }
}
