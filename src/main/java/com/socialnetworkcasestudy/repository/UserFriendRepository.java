package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;
import com.socialnetworkcasestudy.model.RelationshipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFriendRepository extends JpaRepository<Friend, Long> {



    public List<Friend> findBySourceIdAndFriendshipStatusAndRelationshipType(Long id, FriendshipStatus friendshipStatus, RelationshipType relationshipType);

    @Query("select f from Friend f where f.source.id = ?1 and f.friendshipStatus = ?2")
    List<Friend> findBySourceIdAndFriendStatus(Long id, FriendshipStatus friendshipStatus);



}
