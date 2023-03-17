package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;

import java.util.List;
import java.util.Optional;

public interface FriendService {
    List<Friend> findAll();

    Optional<Friend> findById(long id);

    Friend save(Friend Friend);

    void delete(long id);

    List<Friend> listFriendByStatus(String status);


    List<Friend> getActiveFriendList(long id, FriendshipStatus Active);

    List<Friend> getBlockFriendList(long id);

    List<Friend> getNewFriendList(long id);

    void requestCancer(Friend friend);
}
