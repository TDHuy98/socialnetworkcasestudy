package com.socialnetworkcasestudy.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User users;

    @Lob
    @Column(nullable = false)
    private String content;
    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    @OneToMany
    @JoinColumn(name = "posts")
    private Collection<Post> posts = new ArrayList<>();

    private Instant createdAt;
    private Instant updateAt;

    public Post() {
    }

    public Post(Long id, User users, String content, PostStatus postStatus,
                Collection<Post> posts, Instant createdAt, Instant updateAt) {
        this.id = id;
        this.users = users;
        this.content = content;
        this.postStatus = postStatus;
        this.posts = posts;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }
}
