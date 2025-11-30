package com.example.oop_group14.shopowner.Modelclass;

import java.time.LocalDate;

public class Schedule {
    String name, shopName, task;
    LocalDate date;

    public Schedule(String name, String shopName, String task, LocalDate date) {
        this.name = name;
        this.shopName = shopName;
        this.task = task;
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

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
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
                ", task='" + task + '\'' +
                ", date=" + date +
                '}';
    }
}


