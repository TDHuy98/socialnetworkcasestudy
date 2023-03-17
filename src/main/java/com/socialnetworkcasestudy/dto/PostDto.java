package com.socialnetworkcasestudy.dto;


public class PostDto {
    private Long id;
    private Long userId;

    private String img;

    private String firstname;
    private String lastname;
    private String content;
    private String postStatus;
    private Long postId;

    public PostDto() {
    }

    public PostDto(Long id, Long userId, String img, String firstname, String lastname, String content, String postStatus, Long postId) {
        this.id = id;
        this.userId = userId;
        this.img = img;
        this.firstname = firstname;
        this.lastname = lastname;
        this.content = content;
        this.postStatus = postStatus;
        this.postId = postId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
