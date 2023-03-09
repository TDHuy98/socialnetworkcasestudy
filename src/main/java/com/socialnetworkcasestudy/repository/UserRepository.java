package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("select u from User u where upper(u.username) like upper(?1)")
    User findUserByUsername(String username);

    @Query("select u from User u where u.mobile like ?1")
    User findUserByMobile(String mobile);

    @Query("select u from User u where u.email like ?1")
    User findUserByEmail(String email);

    Optional<User> findByUsername(String username);
}
