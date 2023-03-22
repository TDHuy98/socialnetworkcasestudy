package com.socialnetworkcasestudy.dto;

public class CommentDto {
    private Long id;
    private Long userId;
    private String content;
    private Long postId;
    private String profile;
    private String firstname;
    private String middlename;
    private String lastname;


    public CommentDto() {
    }

    public CommentDto(Long id, Long userId, String content, Long postId, String profile, String firstname, String middlename, String lastname) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.postId = postId;
        this.profile = profile;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }





    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
