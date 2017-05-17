package com.example.digdig.listviewmultiplechoice.model;

/**
 * Created by digdig on 17-05-17.
 */

public class Sports {
    private int sportNumber;
    private String sportName;

    public int getSportNumber() {
        return sportNumber;
    }

    public void setSportNumber(int sportNumber) {
        this.sportNumber = sportNumber;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Sports(int sportNumber, String sportName) {
        this.sportNumber = sportNumber;
        this.sportName = sportName;
    }

    @Override
    public String toString() {
        return getSportName();
    }
}
