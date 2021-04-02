package com.ramu.facebook.model;

import java.util.Date;

public class UserDO extends BaseDO {

    private Integer id;
    private String name;
    private String password;

    public UserDO() {
    }

    public UserDO(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserDO(Date createdDate, Date modifiedDate, Integer id, String name, String password) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}