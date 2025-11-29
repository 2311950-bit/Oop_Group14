package com.example.oop_group14.shopowner.Modelclass;

public class Report {
    String issueDetails;

    public Report(String issueDetails) {
        this.issueDetails = issueDetails;
    }

    public String getIssueDetails() {
        return issueDetails;
    }

    public void setIssueDetails(String issueDetails) {
        this.issueDetails = issueDetails;
    }

    @Override
    public String toString() {
        return "Report{" +
                "issueDetails='" + issueDetails + '\'' +
                '}';
    }
}
