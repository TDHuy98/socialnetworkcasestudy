package com.socialnetworkcasestudy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty
    @ManyToOne
    @JoinColumn(name = "sourceId")
    private User source;
    @JsonProperty

    @ManyToOne
    @JoinColumn(name = "targetId")
    private User target;
    @Enumerated(EnumType.STRING)
    private RelationshipType relationshipType;
    @Enumerated(EnumType.STRING)
    private FriendshipStatus friendshipStatus;

    private Instant createdAt;

    private Instant updatedAt;

    public Friend(Long id, User source, User target, RelationshipType relationshipType, FriendshipStatus friendshipStatus, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.relationshipType = relationshipType;
        this.friendshipStatus = friendshipStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Friend() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSource() {
        return source;
    }

    public void setSource(User source) {
        this.source = source;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

    public FriendshipStatus getFriendshipStatus() {
        return friendshipStatus;
    }

    public void setFriendshipStatus(FriendshipStatus friendshipStatus) {
        this.friendshipStatus = friendshipStatus;
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
