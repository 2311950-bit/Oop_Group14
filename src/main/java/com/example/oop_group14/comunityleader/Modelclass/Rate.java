package com.example.oop_group14.comunityleader.Modelclass;

public class Rate {

    String rate,comment,workerCB;

    public Rate(String rate, String comment, String workerCB) {
        this.rate = rate;
        this.comment = comment;
        this.workerCB = workerCB;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWorkerCB() {
        return workerCB;
    }

    public void setWorkerCB(String workerCB) {
        this.workerCB = workerCB;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rate='" + rate + '\'' +
                ", comment='" + comment + '\'' +
                ", workerCB='" + workerCB + '\'' +
                '}';
    }
}


