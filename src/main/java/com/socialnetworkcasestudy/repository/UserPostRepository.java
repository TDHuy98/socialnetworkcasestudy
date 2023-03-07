package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Post;
import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    @Query("select p from Post p where p.users.id=:id")
    List<Post> findAllByUsers_Id(Long id);

}
