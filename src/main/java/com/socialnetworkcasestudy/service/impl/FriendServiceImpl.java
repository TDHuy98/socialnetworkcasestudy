package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;
import com.socialnetworkcasestudy.repository.UserFriendRepository;
import com.socialnetworkcasestudy.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {
    @Autowired
    UserFriendRepository friendRepository;


    public List<Friend> getAllFriendById(Long id, FriendshipStatus friendshipStatus) {
        return friendRepository.findTargetBySourceIdAndStatus(id,friendshipStatus);
    }


    @Override
    public Friend save(Friend friend) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
