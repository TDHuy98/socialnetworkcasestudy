package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
//    List<Post> findAllById(Long id);
}
