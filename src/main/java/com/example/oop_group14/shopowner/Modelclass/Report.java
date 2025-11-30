package com.example.oop_group14.shopowner.Modelclass;

import java.io.Serializable;
import java.time.LocalDate;

public class Report implements Serializable {
    String issueDetails;
    String date;
    public Report(String issueDetails, String date) {
        this.issueDetails = issueDetails;
        this.date = date;
    }

    public String getIssueDetails() {
        return issueDetails;
    }

    public void setIssueDetails(String issueDetails) {
        this.issueDetails = issueDetails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Report{" +
                "issueDetails='" + issueDetails + '\'' +
                '}';
    }
}
