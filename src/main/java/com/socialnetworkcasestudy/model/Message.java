package com.socialnetworkcasestudy.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Message {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "message")
    private Collection<User> users=new ArrayList<>();

    @Lob
    private String message;

    private Instant createdAt;

    private Instant updatedAt;


    public Message() {
    }

    public Message(Long id, Collection<User> users, String message, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.users = users;
        this.message = message;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
