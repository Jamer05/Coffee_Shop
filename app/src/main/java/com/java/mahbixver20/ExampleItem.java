package com.java.mahbixver20;

public class ExampleItem {

    private int image;
    private String name;
    private Float prize;
    public ExampleItem(int image, String name, float prize) {
        this.image = image;
        this.name = name;
        this.prize = prize;
    }
    public int getImageResource() {
        return image;
    }
    public String getText1() {
        return name;
    }
    public float getText2() {
        return prize;
    }
}