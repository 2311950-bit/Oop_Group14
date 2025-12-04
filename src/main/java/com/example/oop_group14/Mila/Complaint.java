package com.example.oop_group14.Mila;

public class Complaint {
    private final int complaintId;
    private final int userId;
    private final String category;
    private final String description;
    private final String address;
    private String status;

    public Complaint(int complaintId, int userId, String category, String description, String address) {
        this.complaintId = complaintId;
        this.userId = userId;
        this.category = category;
        this.description = description;
        this.address = address;
        this.status = "Pending";
    }

    public int getComplaintId() { return complaintId; }
    public int getUserId() { return userId; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getAddress() { return address; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}