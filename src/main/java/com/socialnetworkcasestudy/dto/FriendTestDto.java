package com.socialnetworkcasestudy.dto;

import com.socialnetworkcasestudy.model.FriendshipStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class FriendTestDto {
    private Long id;

    private Long sourceId;

    private Long targetId;
    //    @Enumerated(EnumType.STRING)
//    private RelationshipType relationshipType;
    @Enumerated(EnumType.STRING)
    private FriendshipStatus friendshipStatus;


    public FriendTestDto() {
    }

    public FriendTestDto(Long id, Long sourceId, Long targetId, FriendshipStatus friendshipStatus) {
        this.id = id;
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.friendshipStatus = friendshipStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public FriendshipStatus getFriendshipStatus() {
        return friendshipStatus;
    }

    public void setFriendshipStatus(FriendshipStatus friendshipStatus) {
        this.friendshipStatus = friendshipStatus;
    }
}
