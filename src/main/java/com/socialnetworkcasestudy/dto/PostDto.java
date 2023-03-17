package com.socialnetworkcasestudy.dto;


public class PostDto {
    private Long id;
    private Long userId;
    private String profile;
    private String img;
    private String firstname;
    private String middlename;
    private String lastname;
    private String content;
    private String postStatus;
    private Long postId;
    private Long countLike;

    public PostDto() {
    }

    public PostDto(Long id, Long userId, String profile, String img, String firstname, String middlename, String lastname,
                   String content, String postStatus, Long postId, Long countLike) {
        this.id = id;
        this.userId = userId;
        this.profile = profile;
        this.img = img;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.content = content;
        this.postStatus = postStatus;
        this.postId = postId;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
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

    public Long getCountLike() {
        return countLike;
    }

    public void setCountLike(Long countLike) {
        this.countLike = countLike;
    }
}
