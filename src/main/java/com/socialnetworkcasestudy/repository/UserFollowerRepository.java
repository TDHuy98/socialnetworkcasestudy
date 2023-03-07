package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserFollowerRepository extends JpaRepository<Follower, Long>, JpaSpecificationExecutor<Follower> {
}
