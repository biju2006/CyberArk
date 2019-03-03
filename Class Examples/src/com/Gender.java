package com;

public enum Gender {
    M("Blue"),F("Red");

    private String color;

    private Gender(String color){
        this.color=color;
    }

    public String getColor() {
        return color;
    }
}
