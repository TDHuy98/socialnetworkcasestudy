package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.dto.FriendDto;
import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;
import com.socialnetworkcasestudy.model.RelationshipType;

import java.util.List;
import java.util.Optional;

public interface FriendService {


    List<FriendDto> getFriendListByUserIdStatusType(Long id, FriendshipStatus status, RelationshipType type);

    Friend save(Friend Friend);

    void delete(long id);

    void requestCancer(Friend friend);
}
