package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserFriendRepository extends JpaRepository<Friend, Long>, JpaSpecificationExecutor<Friend> {
}
