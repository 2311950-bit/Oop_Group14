package com.example.oop_group14.shopowner.Modelclass;

public class Register {
    String name,shopName,area,wasteType;

    public Register(String name, String shopName, String area, String wasteType) {
        this.name = name;
        this.shopName = shopName;
        this.area = area;
        this.wasteType = wasteType;
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

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", shopName='" + shopName + '\'' +
                ", area='" + area + '\'' +
                ", wasteType='" + wasteType + '\'' +
                '}';
    }
}
