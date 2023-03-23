package com.socialnetworkcasestudy.dto;


import java.time.Instant;

public class PostDto {
    private Long id;
    private Long userId;
    private String profile;
    private String img;
    private String firstName;
    private String middleName;
    private String lastName;
    private String content;
    private String postStatus;
    private Long postId;
    private Long countLike;

   private Instant createdAt;

    public PostDto() {
    }

    public PostDto(Long id, Long userId, String profile, String img, String firstName, String middleName, String lastName,
                   String content, String postStatus, Long postId, Long countLike, Long likeId, Long userLikedId, String userLikedLastName, Long commentId, Long userCommentedId, String commentContent, Long commentParentId, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.profile = profile;
        this.img = img;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.content = content;
        this.postStatus = postStatus;
        this.postId = postId;
        this.countLike = countLike;
        this.createdAt = createdAt;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
