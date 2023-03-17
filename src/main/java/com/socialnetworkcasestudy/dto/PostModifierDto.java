package com.socialnetworkcasestudy.dto;

import com.socialnetworkcasestudy.model.PostStatus;
import lombok.Data;

@Data
public class PostModifierDto {
    private Long PostId;
    private PostStatus postStatus;
    private String content;
    private String img;

    public PostModifierDto() {
    }

    public PostModifierDto(Long postId, PostStatus postStatus, String content, String img) {
        PostId = postId;
        this.postStatus = postStatus;
        this.content = content;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getPostId() {
        return PostId;
    }

    public void setPostId(Long postId) {
        PostId = postId;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
