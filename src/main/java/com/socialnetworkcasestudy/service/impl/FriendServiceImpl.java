package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;
import com.socialnetworkcasestudy.repository.UserFriendRepository;
import com.socialnetworkcasestudy.service.FriendService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {
    //    @Autowired
    private UserFriendRepository userFriendRepository;

    public FriendServiceImpl(UserFriendRepository userFriendRepository) {
        this.userFriendRepository = userFriendRepository;
    }

    @Override
    public List<Friend> findAll() {
        return userFriendRepository.findAll();
    }

    @Override
    public Optional<Friend> findById(long id) {
        return userFriendRepository.findById(id);
    }

    @Override
    public Friend save(Friend Friend) {
        return userFriendRepository.save(Friend);
    }

    @Override
    public void delete(long id) {
        userFriendRepository.deleteById(id);
    }

    @Override
    public List<Friend> listFriendByStatus(String status) {
        List<Friend> friendListNew = new ArrayList<>();
        for (Friend friend : userFriendRepository.findAll()) {
            if (friend.getFriendshipStatus().equals(status)) {
                friendListNew.add(friend);
            }
        }
        return friendListNew;
    }

    public List<Friend> getNewFriendList() {
        return listFriendByStatus("New");
    }

    @Override
    public List<Friend> getActiveFriendList(long id, FriendshipStatus friendshipStatus) {
        return userFriendRepository.findTargetBySourceIdAndStatus(id, friendshipStatus);

    }

    @Override
    public List<Friend> getBlockFriendList(long id) {
        List<Friend> friendListNew = listFriendByStatus("Block");
        for (Friend friend : friendListNew) {
            if (friend.getId() == id) {
                friendListNew.add(friend);
            }
        }
        return friendListNew;
    }

    @Override
    public List<Friend> getNewFriendList(long id) {
        List<Friend> friendListNew = listFriendByStatus("New");
        for (Friend friend : friendListNew) {
            if (friend.getId() == id) {
                friendListNew.add(friend);
            }
        }
        return friendListNew;
    }

    @Override
    public void requestCancer(Friend friend) {
        for (Friend f : userFriendRepository.findAll()) {
            if (f.getTarget().getId() == friend.getTarget().getId() && f.getSource().getId()==friend.getTarget().getId()){
            }
            if (f.getTarget().getId() == friend.getSource().getId() && f.getSource().getId() == friend.getTarget().getId()){
            }
        }
    }
}
