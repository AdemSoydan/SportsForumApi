package com.wecan.sportsforumapi.entity;

public class TitleSaveRequest {
    private Title title;
    private Entry entry;

    public TitleSaveRequest() {
    }

    public TitleSaveRequest(Title title, Entry entry) {
        this.title = title;
        this.entry = entry;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "TitleSaveRequest{" +
                "title=" + title +
                ", entry=" + entry +
                '}';
    }
}
