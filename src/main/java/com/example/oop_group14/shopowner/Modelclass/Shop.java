package com.example.oop_group14.shopowner.Modelclass;

public class Shop {
    String shopName, wasteStroge,container,status,comment;

    public Shop(String shopName, String wasteStroge, String container, String status, String comment) {
        this.shopName = shopName;
        this.wasteStroge = wasteStroge;
        this.container = container;
        this.status = status;
        this.comment = comment;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getWasteStroge() {
        return wasteStroge;
    }

    public void setWasteStroge(String wasteStroge) {
        this.wasteStroge = wasteStroge;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopName='" + shopName + '\'' +
                ", wasteStroge='" + wasteStroge + '\'' +
                ", container='" + container + '\'' +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
