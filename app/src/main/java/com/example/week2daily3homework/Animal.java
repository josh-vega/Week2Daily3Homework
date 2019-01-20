package com.example.week2daily3homework;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private String type;
    private String name;
    private String sound;
    private int image;
    private int population;

    public Animal() {
    }

    public Animal(String type, String name, String sound, int image, int population) {
        this.type = type;
        this.name = name;
        this.sound = sound;
        this.image = image;
        this.population = population;
    }

    protected Animal(Parcel in) {
        type = in.readString();
        name = in.readString();
        sound = in.readString();
        image = in.readInt();
        population = in.readInt();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(name);
        dest.writeString(sound);
        dest.writeInt(image);
        dest.writeInt(population);
    }
}