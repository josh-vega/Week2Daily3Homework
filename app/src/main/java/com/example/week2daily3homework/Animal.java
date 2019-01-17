package com.example.week2daily3homework;

public class Animal {
    private String type;
    private String name;
    private String sound;
    private int image;

    public Animal() {
    }

    public Animal(String type, String name, String sound, int image) {
        this.type = type;
        this.name = name;
        this.sound = sound;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
