package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserPostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
}
