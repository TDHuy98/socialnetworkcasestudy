package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.service.FriendService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {
    @Override
    public List<Friend> findAll() {
        return null;
    }

    @Override
    public Friend save(Friend friend) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Friend findById(Long id) {
        return null;
    }
}
