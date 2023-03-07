package com.socialnetworkcasestudy.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Collection;

@Entity
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "user_Follow",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follow _id"))
    private Collection<User> userId;

    private FollowerType followerType;

    private Instant createdAt;
    private Instant updatedAt;

    public Follower() {
    }

    public Follower(Long id, Collection<User> userId, FollowerType followerType, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.userId = userId;
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

    public Collection<User> getUserId() {
        return userId;
    }

    public void setUserId(Collection<User> userId) {
        this.userId = userId;
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
