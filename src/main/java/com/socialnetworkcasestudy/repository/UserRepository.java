package com.socialnetworkcasestudy.repository;

import com.socialnetworkcasestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("select u from User u where upper(u.username) like upper(?1)")
    Optional<User> findUserByUsername(String username);

    @Query("select u from User u where u.mobile like ?1")
    Optional<User> findUserByMobile(String mobile);

    @Query("select u from User u where u.email like ?1")
    Optional<User> findUserByEmail(String email);

    Optional<User> findByUsername(String username);

    @Query("select u from User u where u.id = ?1")
    User findUserById(Long id);


}
