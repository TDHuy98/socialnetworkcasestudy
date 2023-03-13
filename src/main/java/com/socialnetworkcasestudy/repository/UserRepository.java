package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.Comment;
import com.socialnetworkcasestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
//    List<User> findAllById(Long id);
    @Query("select u from User u where u.lastName=: lastName")
    User findByName(Long id);
}
