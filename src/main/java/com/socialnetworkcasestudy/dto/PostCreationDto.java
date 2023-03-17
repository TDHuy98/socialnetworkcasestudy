package com.socialnetworkcasestudy.dto;

import com.socialnetworkcasestudy.model.PostStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

/**
 * A DTO for the {@link com.socialnetworkcasestudy.model.Post} entity
 */
@Data
public class PostCreationDto implements Serializable {
    private Long userId;
    private String content;
    private String img;
    private PostStatus postStatus;
    private Collection<Long> postIds;

    public PostCreationDto() {
    }


    public PostCreationDto(Long userId, String content, String img, PostStatus postStatus, Collection<Long> postIds) {
        this.userId = userId;
        this.content = content;
        this.img = img;
        this.postStatus = postStatus;
        this.postIds = postIds;
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

    public Collection<Long> getPostIds() {
        return postIds;
    }

    public void setPostIds(Collection<Long> postIds) {
        this.postIds = postIds;
    }
}
