package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;
import com.socialnetworkcasestudy.model.RelationshipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFriendRepository extends JpaRepository<Friend, Long> {

    @Query(value = "select * from Friend as f  where f.user_id = ?1 and f.friendshipStatus = ?2",nativeQuery = true)
    List<Friend> findTargetBySourceIdAndStatus(Long id, FriendshipStatus friendshipStatus);

    public List<Friend> findBySourceIdAndFriendshipStatusAndRelationshipType(Long id, FriendshipStatus friendshipStatus, RelationshipType relationshipType);
}
