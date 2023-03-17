package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserLikeRepository extends JpaRepository<Likes, Long>, JpaSpecificationExecutor<Likes> {
}
