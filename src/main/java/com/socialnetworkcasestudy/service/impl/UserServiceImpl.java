package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.UserPass;
import com.socialnetworkcasestudy.dto.UserSetting;
import com.socialnetworkcasestudy.exception.ResourceAlreadyExistException;
import com.socialnetworkcasestudy.exception.ResourceNotFoundException;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

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
        return userRepository.findUserById(id).get();
    }

    @Override
    public UserSetting getUserUpdate(Long id) {
        return userToUserSetting(userRepository.findUserById(id).get());
    }

    @Override
    public UserSetting updateUserInformation(UserSetting userSetting) {
        User userFound = userRepository.findUserById(userSetting.getId()).get();
        if (userRepository.findUserByEmail(userSetting.getEmail()).isPresent()
                &&
            !userRepository.findUserByEmail(userSetting.getEmail())
                    .equals(userRepository.findUserById(userSetting.getId()))
        ) {
            throw new ResourceAlreadyExistException("This email has already exist, please use another");
        } else {
            userFound.setEmail(userSetting.getEmail());
        }
        if (userRepository.findUserByMobile(userSetting.getMobile()).isPresent()
        &&
        !userRepository.findUserByMobile(userSetting.getMobile())
                .equals(userRepository.findUserById(userSetting.getId()))) {
            throw new ResourceAlreadyExistException("This mobile has already exist, please use another");
        } else {
            userFound.setMobile(userSetting.getMobile());

        }
        userFound.setFirstname(userSetting.getFirstname());
        userFound.setMiddlename(userSetting.getMiddlename());
        userFound.setLastname(userSetting.getLastname());
        userFound.setIntro(userSetting.getIntro());
        userFound.setUpdatedAt(Instant.now());
        userRepository.save(userFound);
        return userSetting;
    }


    @Override
    public UserPass changeUserPassword(UserPass userPass) {
        if (passwordEncoder
                .matches(userPass.getOldPassword(),
                        userRepository.findUserById(userPass.getUserId()).get().getPassword())) {
            User userChangePassword = userRepository.findUserById(userPass.getUserId()).get();
            userChangePassword.setPassword(passwordEncoder.encode(userPass.getNewPassword()));
            userChangePassword.setUpdatedAt(Instant.now());
            userRepository.save(userChangePassword);
        } else {
            throw new ResourceNotFoundException("Wrong old password, please try again");
        }
        return userPass;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    private User userSettingToUser(UserSetting userSetting) {
        return modelMapper.map(userSetting, User.class);
    }

    private UserSetting userToUserSetting(User user) {
        return modelMapper.map(user, UserSetting.class);
    }

}
