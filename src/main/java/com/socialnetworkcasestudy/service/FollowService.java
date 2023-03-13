package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Follower;

import java.util.List;

public interface FollowService {
    List<Follower> findAll();

    Follower save(Follower follower);

    void delete(Long id);

    Follower findById( Long id);
}
