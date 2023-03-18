package com.socialnetworkcasestudy.dto;


import com.socialnetworkcasestudy.model.FriendshipStatus;
import com.socialnetworkcasestudy.model.RelationshipType;

import java.util.List;

public class FriendDto {
    private Long id;

    private UserDto source;

    private UserDto target;
    private RelationshipType relationshipType;
    private FriendshipStatus friendshipStatus;


    public FriendDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getSource() {
        return source;
    }

    public void setSource(UserDto source) {
        this.source = source;
    }

    public UserDto getTarget() {
        return target;
    }

    public void setTarget(UserDto target) {
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

    public FriendDto(Long id, UserDto source, UserDto target, RelationshipType relationshipType, FriendshipStatus friendshipStatus) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.relationshipType = relationshipType;
        this.friendshipStatus = friendshipStatus;
    }
}
