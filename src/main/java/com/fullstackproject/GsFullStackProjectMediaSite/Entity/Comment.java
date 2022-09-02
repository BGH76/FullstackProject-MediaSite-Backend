package com.fullstackproject.GsFullStackProjectMediaSite.Entity;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long postId;
    private Long userId;
    private String comment;

    public Comment(Long id, Long postId, Long userId, String comment) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
    }

    public Comment(Long postId, Long userId, String comment) {
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
