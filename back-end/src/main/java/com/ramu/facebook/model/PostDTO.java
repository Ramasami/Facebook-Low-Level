package com.ramu.facebook.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {

    private Integer id;
    private Integer userId;
    private String post;
    private List<CommentDTO> comments;
    private List<LikeDTO> likes;
    private Date createdDate;

    public PostDTO() {
    }

    public PostDTO(Integer id, Integer userId, String post, Date createdDate) {
        this.id = id;
        this.userId = userId;
        this.post = post;
        this.createdDate = createdDate;
    }

    public PostDTO(Integer id, Integer userId, String post, List<CommentDTO> comments, List<LikeDTO> likes, Date createdDate) {
        this.id = id;
        this.userId = userId;
        this.post = post;
        this.comments = comments;
        this.likes = likes;
        this.createdDate = createdDate;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public List<LikeDTO> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeDTO> likes) {
        this.likes = likes;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
