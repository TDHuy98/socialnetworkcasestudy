package com.socialnetworkcasestudy.dto;

import com.socialnetworkcasestudy.model.Comment;
import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collection;

public class CommentDto {
    private Long id;
    private Long userId;
    private String content;
    private Long postId;
    private Long commentId;

    public CommentDto() {
    }

    public CommentDto(Long id, Long userId, String content, Long postId, Long commentId) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.postId = postId;
        this.commentId = commentId;
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

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}
