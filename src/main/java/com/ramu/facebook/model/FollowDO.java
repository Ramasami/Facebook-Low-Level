package com.ramu.facebook.model;

import java.util.Date;

public class FollowDO extends BaseDO {

    private Integer id;
    private Integer fromUserId;
    private Integer toUserId;

    public FollowDO() {
    }

    public FollowDO(Integer id, Integer fromUserId, Integer toUserId) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
    }

    public FollowDO(Date createdDate, Date modifiedDate, Integer id, Integer fromUserId, Integer toUserId) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
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

}
