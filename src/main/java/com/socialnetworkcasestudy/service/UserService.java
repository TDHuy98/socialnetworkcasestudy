package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUserName(String username);

    Optional<User> findById(Long id);

    User findUserById(Long id);

    List<User> findUsersBySearchName(String username);


}
