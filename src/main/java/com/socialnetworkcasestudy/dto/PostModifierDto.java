package com.socialnetworkcasestudy.dto;

import com.socialnetworkcasestudy.model.PostStatus;
import lombok.Data;

@Data
public class PostModifierDto {
    private Long id;
    private PostStatus postStatus;
    private String content;

    public PostModifierDto() {
    }

    public PostModifierDto(Long id, PostStatus postStatus, String content) {
        this.id = id;
        this.postStatus = postStatus;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
