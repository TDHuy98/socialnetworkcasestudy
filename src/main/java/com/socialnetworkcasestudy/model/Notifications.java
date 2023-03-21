package com.socialnetworkcasestudy.model;

import jakarta.persistence.*;


@Entity
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private String content;
    private String status;
    private Long userId;
    private String userLastName;
    private String targetAvatar;
    private String type;

    public Notifications() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getTargetAvatar() {
        return targetAvatar;
    }

    public void setTargetAvatar(String targetAvatar) {
        this.targetAvatar = targetAvatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Notifications(Long id, Long postId, String content, String status, Long userId, String userLastName, String targetAvatar, String type) {
        this.id = id;
        this.postId = postId;
        this.content = content;
        this.status = status;
        this.userId = userId;
        this.userLastName = userLastName;
        this.targetAvatar = targetAvatar;
        this.type = type;
    }
}
