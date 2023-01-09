package com.example.spring01.rest;

public class Customer {
    private long customerId;
    private String customerName;
    private double debit;


    public Customer() {
    }

    public Customer(long customerId, String customerName, double debit) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.debit = debit;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }
}
