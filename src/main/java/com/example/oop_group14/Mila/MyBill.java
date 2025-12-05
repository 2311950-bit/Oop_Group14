package com.example.oop_group14.Mila;

import java.time.LocalDate;

public class MyBill {
    private String month;
    private Integer amount;
    private LocalDate date;
    private String status;

    public MyBill(String month, Integer amount, LocalDate date, String status) {
        this.month = month;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MyBill{" +
                "month='" + month + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
