package com.socialnetworkcasestudy.dto;

import com.socialnetworkcasestudy.model.PostStatus;
import lombok.Data;

@Data
public class PostUpdateDto {
    private Long id;
    private Long userId;
    private String content;
    private String img;
    private PostStatus postStatus;

    public PostUpdateDto() {
    }

    public PostUpdateDto( Long id,Long userId, String content, String img, PostStatus postStatus) {
        this.userId = userId;
        this.id = id;
        this.content = content;
        this.img = img;
        this.postStatus = postStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return id;
    }

    public void setPostId(Long postId) {
        this.id = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }
}
