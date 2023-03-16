package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.UserDto;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUserByUserName(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<UserDto> findUsersBySearchName(String username) {

        return userRepository.findUsersBySearchName(username)
                .stream()
                .map(this::userToUserDto)
                .toList();
    }

    private UserDto userToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }


}
