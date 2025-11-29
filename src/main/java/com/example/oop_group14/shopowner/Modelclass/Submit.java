package com.example.oop_group14.shopowner.Modelclass;

import java.time.LocalDate;

public class Submit {
    String shopName,area,comment;
    LocalDate date;

    public Submit(String shopName, String area, String comment, LocalDate date) {
        this.shopName = shopName;
        this.area = area;
        this.comment = comment;
        this.date = date;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Submit{" +
                "shopName='" + shopName + '\'' +
                ", area='" + area + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
