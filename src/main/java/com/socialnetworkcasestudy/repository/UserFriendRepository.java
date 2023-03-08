package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFriendRepository extends JpaRepository<Friend, Long> {
    @Query("select f from Friend f where f.source.id = ?1 and f.friendshipStatus = ?2")
    List<Friend> findTargetBySourceIdAndStatus(Long id, FriendshipStatus friendshipStatus);


}
