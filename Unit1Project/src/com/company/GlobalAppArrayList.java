package com.company;

public class GlobalAppArrayList {
    private String name;
    private int cityNum;
    private int StuffNum;

    public GlobalAppArrayList(String Name, int Ci, int Si ){
        this.cityNum = Ci;
        this.StuffNum = Si;
        this.name = Name;
    }
    public String getName1() {
        return name;
    }
    public void AddcityNum1(){
        this.cityNum++;
    }
    public void AddstuffNum1(){
        this.StuffNum++;
    }
    public int getCityNum1() {
        return cityNum;
    }
    public int getStuffNum1() {
        return StuffNum;
    }
}

