package com.ramu.facebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class BaseDO {

    private Date createdDate;

    @JsonIgnore
    private Date modifiedDate;

    public BaseDO() {
    }

    public BaseDO(Date createdDate, Date modifiedDate) {
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
