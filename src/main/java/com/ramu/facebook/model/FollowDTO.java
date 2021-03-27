package com.ramu.facebook.model;

import java.util.Date;

public class FollowDTO {

    private Integer id;
    private Integer fromUserId;
    private Integer toUserId;
    private Date createdDate;

    public FollowDTO() {
    }

    public FollowDTO(Integer id, Integer fromUserId, Integer toUserId, Date createdDate) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
