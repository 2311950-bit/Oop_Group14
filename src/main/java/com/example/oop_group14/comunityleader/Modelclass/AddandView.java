package com.example.oop_group14.comunityleader.Modelclass;

public class AddandView {
    String areaName,remarks;
    int wasteKG;

    public AddandView(String areaName, String remarks, int wasteKG) {
        this.areaName = areaName;
        this.remarks = remarks;
        this.wasteKG = wasteKG;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getWasteKG() {
        return wasteKG;
    }

    public void setWasteKG(int wasteKG) {
        this.wasteKG = wasteKG;
    }

    @Override
    public String toString() {
        return "AddandView{" +
                "areaName='" + areaName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", wasteKG=" + wasteKG +
                '}';
    }
}
