package com.socialnetworkcasestudy.dto;

public class CommentDto {
    private Long id;
    private Long userId;
    private String content;
    private Long postId;
    private String profile;
    private String firstName;
    private String middleName;
    private String lastName;


    public CommentDto() {
    }

    public CommentDto(Long id, Long userId, String content, Long postId, String profile, String firstName, String middleName, String lastName) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.postId = postId;
        this.profile = profile;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
