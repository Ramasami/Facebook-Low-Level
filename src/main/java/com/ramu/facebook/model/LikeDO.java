package com.ramu.facebook.model;

import com.ramu.facebook.utils.exceptions.LikeEnum;

import java.util.Date;

public class LikeDO extends BaseDO {

    private Integer id;
    private Integer userId;
    private Integer postId;
    private LikeEnum likeEnum;

    public LikeDO() {
    }

    public LikeDO(Integer id, Integer userId, Integer postId, LikeEnum likeEnum) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.likeEnum = likeEnum;
    }

    public LikeDO(Date createdDate, Date modifiedDate, Integer id, Integer userId, Integer postId, LikeEnum likeEnum) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.likeEnum = likeEnum;
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

    public LikeEnum getLike() {
        return likeEnum;
    }

    public void setLike(LikeEnum likeEnum) {
        this.likeEnum = likeEnum;
    }
}
