package com.example.oop_group14.Mila;

import java.time.LocalDate;

public class ComplaintStatus {
    private Integer complaintID;
    private LocalDate date;

    public ComplaintStatus(Integer complaintID, LocalDate date) {
        this.complaintID = complaintID;
        this.date = date;
    }

    public Integer getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(Integer complaintID) {
        this.complaintID = complaintID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ComplaintStatus{" +
                "complaintID=" + complaintID +
                ", date=" + date +
                '}';
    }
}
