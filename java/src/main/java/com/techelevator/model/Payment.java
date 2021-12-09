package com.techelevator.model;

import java.util.Objects;

public class Payment {

    private long paymentId;
    private int unitId;
    private int userId;
    private int cardNumber;
    private String expirationDate;
    private int cvc;
    private int amountPaid;
    private boolean isPaymentApproved;

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public boolean isPaymentApproved() {
        return isPaymentApproved;
    }

    public void setPaymentApproved(boolean paymentApproved) {
        isPaymentApproved = paymentApproved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentId == payment.paymentId && unitId == payment.unitId && userId == payment.userId && cardNumber == payment.cardNumber && cvc == payment.cvc && amountPaid == payment.amountPaid && isPaymentApproved == payment.isPaymentApproved && Objects.equals(expirationDate, payment.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, unitId, userId, cardNumber, expirationDate, cvc, amountPaid, isPaymentApproved);
    }
}
