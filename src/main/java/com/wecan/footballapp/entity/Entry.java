package com.wecan.footballapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


import java.util.Optional;

@Table(name = "entry")
@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_id")
    private int eId;
    @Column(name = "entry_text")
    private String entryText;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="title_id", nullable=false)
    private Title title;

    public Entry(String entryText, Title title) {
        this.entryText = entryText;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "eId=" + eId +
                ", entryText='" + entryText + '\'' +
                ", title=" + title +
                '}';
    }

    public Entry() {
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getEntryText() {
        return entryText;
    }

    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}