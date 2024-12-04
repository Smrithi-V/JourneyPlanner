package com.example.delhimetroroute;

import java.util.Objects;

public class MyData {
    private int image;
    private String title;

    // Constructor
    public MyData(int image, String title) {
        this.image = image;
        this.title = title;
    }

    // Getter methods
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    // Setter methods
    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Override toString() to provide a string representation of the object
    @Override
    public String toString() {
        return "MyData{" +
                "image=" + image +
                ", title='" + title + '\'' +
                '}';
    }

    // Override equals() for comparison between two MyData objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return image == myData.image && Objects.equals(title, myData.title);
    }

    // Override hashCode() to generate a hash code for the object
    @Override
    public int hashCode() {
        return Objects.hash(image, title);
    }
}
