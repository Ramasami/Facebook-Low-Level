package com.ramu.facebook.model;

import java.util.Date;

public class CommentDO extends BaseDO {

    private Integer id;
    private Integer userId;
    private Integer postId;
    private String comment;

    public CommentDO() {
    }

    public CommentDO(Integer id, Integer userId, Integer postId, String comment) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.comment = comment;
    }

    public CommentDO(Date createdDate, Date modifiedDate, Integer id, Integer userId, Integer postId, String comment) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.comment = comment;
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
