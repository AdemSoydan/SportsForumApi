package com.wecan.sportsforumapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "title")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private int tId;

    @Column(name = "title_name")
    private String titleName;

    @JsonManagedReference()
    @OneToMany(mappedBy="title")
    private List<Entry> entries;

    public Title() {
    }

    public Title(String titleName) {
        this.titleName = titleName;
        entries = new ArrayList<>();
    }

    public void addEntry(Entry entry){
        entries.add(entry);
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + tId +
                ", titleName='" + titleName + '\'' +
                ", entries=" + entries +
                '}';
    }
}
