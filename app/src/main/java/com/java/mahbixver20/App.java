package com.java.mahbixver20;

public class App {
    int image;
    String name;
    int prize;

    public App(int image, String name, int prize) {
        this.image = image;
        this.name = name;
        this.prize = prize;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return prize;
    }
}
