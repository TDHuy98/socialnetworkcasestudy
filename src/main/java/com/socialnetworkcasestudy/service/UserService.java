package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUserName(String username);

    Optional<User> findById(Long id);
    User findUserById(Long id);
}
