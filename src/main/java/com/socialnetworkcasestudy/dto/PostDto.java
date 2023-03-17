package com.socialnetworkcasestudy.dto;


import jakarta.persistence.Column;

public class PostDto {
    private Long id;
    private Long userId;
    private String Avatar;
    private String Img;
    private String firstname;
    private String lastname;
    private String content;
    private String postStatus;

    private Long countLike;

    public PostDto() {
    }

    public PostDto(Long id, Long userId, String avatar, String img, String firstname, String lastname, String content, String postStatus, Long countLike) {
        this.id = id;
        this.userId = userId;
        Avatar = avatar;
        Img = img;
        this.firstname = firstname;
        this.lastname = lastname;
        this.content = content;
        this.postStatus = postStatus;
        this.countLike = countLike;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public Long getCountLike() {
        return countLike;
    }

    public void setCountLike(Long countLike) {
        this.countLike = countLike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }
}
