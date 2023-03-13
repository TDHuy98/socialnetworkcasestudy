package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);

    void delete(Long id);

    User findById( Long id);


}
