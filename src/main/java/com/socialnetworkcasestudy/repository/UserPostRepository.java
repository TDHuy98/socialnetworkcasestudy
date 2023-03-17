package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Post;
import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    @Query( value = "select *  from Post where (post.user_id =?1  and post_status = ('public' || 'friend'))",nativeQuery = true)
    List<Post> findAllByUsers_Id(Long id);

    @Query(value = "select *  from Post where (post.user_id =?1  and post_status = ('public' || 'friend'))",nativeQuery = true)
    List<Post> findProfilePost(Long id);
}
