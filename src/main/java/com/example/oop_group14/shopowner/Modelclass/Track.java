package com.example.oop_group14.shopowner.Modelclass;

public class Track {
    String shopName,type;
    Float amount;

    public Track(String shopName, String type, Float amount) {
        this.shopName = shopName;
        this.type = type;
        this.amount = amount;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Track{" +
                "shopName='" + shopName + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
