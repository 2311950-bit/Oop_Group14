package com.example.oop_group14.Mila;

import java.time.LocalDate;

public class CleanlinessFeedback {

    private String authorName;
    private String service;
    private LocalDate date;

    public CleanlinessFeedback(String authorName, String service, LocalDate date) {
        this.authorName = authorName;
        this.service = service;
        this.date = date;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CleanlinessFeedback{" +
                "authorName='" + authorName + '\'' +
                ", service='" + service + '\'' +
                ", date=" + date +
                '}';
    }
}
