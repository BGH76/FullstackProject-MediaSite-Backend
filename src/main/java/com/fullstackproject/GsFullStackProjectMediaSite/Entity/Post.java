package com.fullstackproject.GsFullStackProjectMediaSite.Entity;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Builder
@Entity
public class Post implements Comparable<Post>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String post;

    private LocalDate date = LocalDate.now();

    public Post(Long id, Long userId, String post, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.post = post;
        this.date = date;
    }

    public Post(Long userId, String post) {
        this.userId = userId;
        this.post = post;
    }


    public Post(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int compareTo(Post o) {
        return (int)(ChronoUnit.DAYS.between(date,o.getDate()));
    }
}
