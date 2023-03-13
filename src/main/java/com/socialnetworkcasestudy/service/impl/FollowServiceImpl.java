package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Follower;
import com.socialnetworkcasestudy.repository.UserFollowerRepository;
import com.socialnetworkcasestudy.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FollowServiceImpl implements FollowService {
    @Autowired
    UserFollowerRepository userFollowerRepository;
    @Override
    public List<Follower> findAll() {
        return userFollowerRepository.findAll();
    }

    @Override
    public Follower save(Follower follower) {
        return userFollowerRepository.save(follower);
    }

    @Override
    public void delete(Long id) {
        userFollowerRepository.deleteById(id);

    }

    @Override
    public Follower findById(Long id) {
        return userFollowerRepository.findById(id).get();
    }
}
