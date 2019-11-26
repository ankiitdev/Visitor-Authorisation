package com.example.visitorauthorisation;

import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("ledno")
    private int ledno;

    @SerializedName("state")
    private String state;

    public Status(int ledno, String state) {
        this.ledno = ledno;
        this.state = state;
    }

    public int getLedno() {
        return ledno;
    }

    public void setLedno(int ledno) {
        this.ledno = ledno;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}