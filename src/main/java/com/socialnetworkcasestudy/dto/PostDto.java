package com.socialnetworkcasestudy.dto;


public class PostDto {
    private Long id;
    private Long userId;
    private String content;
    private String postStatus;

    public PostDto() {
    }

    public PostDto(Long id, Long userId, String content, String postStatus) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.postStatus = postStatus;
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

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }
}
