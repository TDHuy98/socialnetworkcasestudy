package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserCommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
    @Query("select c from Comment c where c.post.id = ?1")
    List<Comment> findAllByPostId(Long id);



}
