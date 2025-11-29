package com.example.oop_group14.shopowner.Modelclass;

import java.time.LocalDate;

public class Schedule {
    String name ,shopName,area;
    LocalDate date;

    public Schedule(String name, String shopName, String area, LocalDate date) {
        this.name = name;
        this.shopName = shopName;
        this.area = area;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "name='" + name + '\'' +
                ", shopName='" + shopName + '\'' +
                ", area='" + area + '\'' +
                ", date=" + date +
                '}';
    }
}
