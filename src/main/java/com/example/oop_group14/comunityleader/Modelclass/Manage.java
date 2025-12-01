package com.example.oop_group14.comunityleader.Modelclass;

import java.time.LocalDate;

public class Manage {
    String name,area,bin;
    String date;

    public Manage(String name, String area, String bin, String date) {
        this.name = name;
        this.area = area;
        this.bin = bin;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Manage{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", bin='" + bin + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}


