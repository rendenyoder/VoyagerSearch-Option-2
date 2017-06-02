package com.example.demo.helper;

import com.example.demo.models.Sample;

import java.util.LinkedList;

public class Alerts {
    //List to store alerts
    private LinkedList<String> recentlyChangedItems;
    //Initialize list when object is constructed
    public Alerts(){
        recentlyChangedItems = new LinkedList<>();
    }
    //Get the current list of alerts
    public LinkedList<String> getRecentlyChangedItems() {
        return recentlyChangedItems;
    }
}
