package com.example.oop_group14.comunityleader.Modelclass;

import java.time.LocalDate;

public class Assign {
    String name, area, task;
    LocalDate date;

    public Assign(String name, String area, String task, LocalDate date) {
        this.name = name;
        this.area = area;
        this.task = task;
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
        return "Assign{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", task='" + task + '\'' +
                ", date=" + date +
                '}';
    }
}
