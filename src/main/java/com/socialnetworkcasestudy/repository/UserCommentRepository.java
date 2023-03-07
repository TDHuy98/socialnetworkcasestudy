package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserCommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
}
