package com.ramu.facebook.model;

import java.util.Date;

public class CommentDTO {

    private Integer id;
    private Integer userId;
    private Integer postId;
    private String comment;
    private Date createdDate;

    public CommentDTO() {
    }

    public CommentDTO(Integer id, Integer userId, Integer postId, String comment, Date createdDate) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.comment = comment;
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
