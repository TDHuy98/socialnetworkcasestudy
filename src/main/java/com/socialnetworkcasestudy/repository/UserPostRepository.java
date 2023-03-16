package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.dto.PostDto;
import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.model.PostStatus;
import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    @Query("select p from Post p where p.user.id = ?1")
    List<Post> findAllByUsers_Id(Long id);

    @Query(value = "select *  from Post where (post.user_id =?1  and post_status = ('public' || 'friend'))", nativeQuery = true)
    List<Post> ShowPostByIdAndPostStatus (Long id);


}
