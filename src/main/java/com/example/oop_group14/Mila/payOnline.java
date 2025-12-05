package com.example.oop_group14.Mila;

import java.time.LocalDate;

public class payOnline {
    private String method;
    private Integer transactionID;
    private String mobileno;
    private Integer amount;
    private LocalDate date;


    public payOnline(String method, Integer transactionID, String mobileno, Integer amount, LocalDate date) {
        this.method = method;
        this.transactionID = transactionID;
        this.mobileno = mobileno;
        this.amount = amount;
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "payOnline{" +
                "method='" + method + '\'' +
                ", transactionID=" + transactionID +
                ", mobileno='" + mobileno + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
