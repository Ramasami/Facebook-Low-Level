package com.ramu.facebook.model;

import java.util.Date;

public class UserDTO {

    private Integer id;
    private String name;
    private String password;
    private Date createdDate;

    public UserDTO(Integer id, String name, String password, Date createdDate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
    }

    public UserDTO() {
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
