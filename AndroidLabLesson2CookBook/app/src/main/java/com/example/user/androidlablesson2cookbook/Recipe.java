package com.example.user.androidlablesson2cookbook;

/**
 * Created by Bulat Murtazin on 11.07.2017.
 */

public class Recipe {

    private String name;
    private String time;
    private String description;
    private String difficulty;

    public Recipe(String name, String time, String description, String difficulty) {
        this.name = name;
        this.time = time;
        this.description = description;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
