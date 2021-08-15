package com.example.tourguideapp;

public class Info {



    private String name;
    private int imageResourceID;
    private String description;


    public Info(String name, int imageResourceID, String description) {
        this.name = name;
        this.imageResourceID = imageResourceID;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public int getImageResourceID() {
        return imageResourceID;
    }


}
