package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.FriendDto;
import com.socialnetworkcasestudy.dto.UserDto;
import com.socialnetworkcasestudy.model.Friend;
import com.socialnetworkcasestudy.model.FriendshipStatus;
import com.socialnetworkcasestudy.model.RelationshipType;
import com.socialnetworkcasestudy.repository.UserFriendRepository;
import com.socialnetworkcasestudy.service.FriendService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {
    @Autowired
    private UserFriendRepository userFriendRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<FriendDto> getFriendListByUserIdStatusType(Long id, FriendshipStatus status, RelationshipType type) {
        List<FriendDto> friendDtoList = new ArrayList();
        for (Friend f : userFriendRepository.findBySourceIdAndFriendshipStatusAndRelationshipType(id, status, type)) {
            FriendDto friendDto = new FriendDto();
            UserDto souceDto = new UserDto();
            UserDto targetDto = new UserDto();

            friendDto.setId(f.getId());

            souceDto.setId(f.getSource().getId());
            souceDto.setFirstname(f.getSource().getFirstName());
            souceDto.setMiddleName(f.getSource().getMiddleName());
            souceDto.setLastName(f.getSource().getLastName());
            souceDto.setProfile(f.getSource().getProfile());

            targetDto.setId(f.getTarget().getId());
            targetDto.setFirstname(f.getTarget().getFirstName());
            targetDto.setMiddleName(f.getTarget().getMiddleName());
            targetDto.setLastName(f.getTarget().getLastName());
            targetDto.setProfile(f.getTarget().getProfile());

            friendDto.setRelationshipType(f.getRelationshipType());
            friendDto.setFriendshipStatus(f.getFriendshipStatus());

            friendDto.setSource(souceDto);
            friendDto.setTarget(targetDto);
            friendDtoList.add(friendDto);
        }
        return friendDtoList;
    }

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

    public List<Friend> getBlockFriendList(long id) {
        List<Friend> friendListNew = listFriendByStatus("Block");
        for (Friend friend : friendListNew) {
            if (friend.getId() == id) {
                friendListNew.add(friend);
            }
        }
        return friendListNew;
    }

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
            if (f.getTarget().getId() == friend.getTarget().getId() && f.getSource().getId() == friend.getTarget().getId()) {
            }
            if (f.getTarget().getId() == friend.getSource().getId() && f.getSource().getId() == friend.getTarget().getId()) {
            }
        }
    }

    private FriendDto friendToFriendDto(Friend friend) {
        return modelMapper.map(friend, FriendDto.class);
    }
}
