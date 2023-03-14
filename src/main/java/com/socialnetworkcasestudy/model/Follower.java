package com.socialnetworkcasestudy.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user1")
    private User user1;
    @ManyToOne
    @JoinColumn(name = "user2")
    private User user2;
    @Enumerated(EnumType.STRING)
    private FollowerType followerType;

    private Instant createdAt;
    private Instant updatedAt;

    public Follower() {
    }

    public Follower(Long id, User user1, User user2, FollowerType followerType, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.user1 = user1;
        this.user2 = user2;
        this.followerType = followerType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public FollowerType getFollowerType() {
        return followerType;
    }

    public void setFollowerType(FollowerType followerType) {
        this.followerType = followerType;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
