package com.java.mahbixver20;

public class PopularCoffee {
    int image;
    String name;
    String prize;

    public PopularCoffee(int image, String name, String prize) {
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

    public String getSize() {
        return prize;
    }
}
