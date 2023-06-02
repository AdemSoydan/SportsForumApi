package com.wecan.sportsforumapi.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

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
    @JsonIgnore
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="tId")
    @JoinColumn(name="title_id")
    private Title title;


    @ManyToOne
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="userId")
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "number_of_liked")
    private int noOfLiked;

    public Entry(int eId, String entryText, Title title, User user, int noOfLiked) {
        this.eId = eId;
        this.entryText = entryText;
        this.title = title;
        this.user = user;
        this.noOfLiked = noOfLiked;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "eId=" + eId +
                ", entryText='" + entryText + '\'' +
                ", title=" + title +
                 "user"+ user +
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
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getNoOfLiked() {
        return noOfLiked;
    }

    public void setNoOfLiked(int noOfLiked) {
        this.noOfLiked = noOfLiked;
    }

}