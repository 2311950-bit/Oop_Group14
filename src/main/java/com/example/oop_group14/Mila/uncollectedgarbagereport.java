package com.example.oop_group14.Mila;

import java.time.LocalDate;

public class uncollectedgarbagereport {
    private String time;
    private LocalDate date;
    private String location;

    public uncollectedgarbagereport(String time, LocalDate date, String location) {
        this.time = time;
        this.date = date;
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "uncollectedgarbagereport{" +
                "time='" + time + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                '}';
    }
}
