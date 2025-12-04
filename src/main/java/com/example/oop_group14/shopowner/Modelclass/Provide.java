package com.example.oop_group14.shopowner.Modelclass;

import java.io.Serializable;

public class Provide implements Serializable {
    String name, area, comment;
    int rating;

    public Provide(String name, String area, int rating, String comment) {
        this.name = name;
        this.area = area;
        this.rating = rating;
        this.comment = comment;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Provide{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", rating=" + rating +
                '}';
    }
}