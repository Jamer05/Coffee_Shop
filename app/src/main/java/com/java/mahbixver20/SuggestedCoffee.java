package com.java.mahbixver20;

public class SuggestedCoffee {

    private String Title;
    private String Category ;
    private int Description ;
    private int Thumbnail ;

    public SuggestedCoffee(String title, String category, int description, int thumbnail) {
        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
    }


    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public int getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

}