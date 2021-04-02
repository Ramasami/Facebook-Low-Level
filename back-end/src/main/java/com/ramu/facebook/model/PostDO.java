package com.ramu.facebook.model;

import java.util.Date;

public class PostDO extends BaseDO {

    private Integer id;
    private Integer userId;
    private String post;

    public PostDO() {
    }

    public PostDO(Integer id, Integer userId, String post) {
        this.id = id;
        this.userId = userId;
        this.post = post;
    }

    public PostDO(Date createdDate, Date modifiedDate, Integer id, Integer userId, String post) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.userId = userId;
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
