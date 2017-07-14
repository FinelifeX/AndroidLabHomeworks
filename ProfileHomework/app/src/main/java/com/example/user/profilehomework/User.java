package com.example.user.profilehomework;

/**
 * Created by Bulat Murtazin on 12.07.2017.
 */

public class User {

    private String name;
    private String name2;
    private String number;
    private long lastVisit;

    public User(String name, String name2, String number, long lastVisit) {
        this.name = name;
        this.name2 = name2;
        this.number = number;
        this.lastVisit = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(long lastVisit) {
        this.lastVisit = lastVisit;
    }
}
