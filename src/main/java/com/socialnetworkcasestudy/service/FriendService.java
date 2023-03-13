package com.socialnetworkcasestudy.service;


import com.socialnetworkcasestudy.model.Friend;

import java.util.List;

public interface FriendService {
    List<Friend> findAll();

    Friend save(Friend friend);

    void delete(Long id);

    Friend findById( Long id);

}
