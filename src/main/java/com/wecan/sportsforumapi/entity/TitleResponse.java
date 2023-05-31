package com.wecan.sportsforumapi.entity;

import java.util.List;

public class TitleResponse {
    private String titleName;
    private int numberOfEntries;
    private int titleId;

    public TitleResponse(String titleName, int numberOfEntries, int titleId) {
        this.titleName = titleName;
        this.numberOfEntries = numberOfEntries;
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    @Override
    public String toString() {
        return "TitleResponse{" +
                "titleName='" + titleName + '\'' +
                ", numberOfEntries=" + numberOfEntries +
                ", titleId=" + titleId +
                '}';
    }
}
