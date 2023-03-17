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
    private User user;

    @Lob
    @Column(nullable = false)
    private String content;

    private String img;
    @Enumerated(EnumType.STRING)

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;
    @Column
    private String img;
    @Column
    private Long countLike;

    public Post(Long id, User user, String content, PostStatus postStatus, String img, Collection<Post> posts, Instant createdAt, Instant updateAt) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.postStatus = postStatus;
        this.img = img;
        this.posts = posts;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @OneToMany
    @JoinColumn(name = "posts")
    private Collection<Post> posts = new ArrayList<>();

    private Instant createdAt;
    private Instant updateAt;

    public Post() {
    }

    public Post(Long id, User user, String content,String img, PostStatus postStatus,
    public Post(Long id, User user, String content, PostStatus postStatus,
                Collection<Post> posts, Instant createdAt, Instant updateAt) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.img=img;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
