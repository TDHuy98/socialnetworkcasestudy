package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.UserPass;
import com.socialnetworkcasestudy.dto.UserSetting;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        return userRepository.findUserById(id);
    }

    @Override
    public UserSetting getUserUpdate(Long id) {
        return userToUserSetting(userRepository.findUserById(id));
    }

    @Override
    public UserSetting updateUserInformation(UserSetting userSetting) {
        User userFound = userRepository.findUserById(userSetting.getId());
        userFound.setFirstName(userSetting.getFirstName());
        userFound.setMiddleName(userSetting.getMiddleName());
        userFound.setLastName(userSetting.getLastName());
        userFound.setEmail(userSetting.getEmail());
        userFound.setIntro(userSetting.getIntro());
        userFound.setUpdatedAt(Instant.now());
        userRepository.save(userFound);
        return userSetting;
    }

    @Override
    public boolean checkPasswordExisted(UserPass userPass) {
        return passwordEncoder.matches(userPass.getPassword(), userRepository.findUserById(userPass.getUserId()).getPassword());

    }

    @Override
    public void changeUserPassword(UserPass userPass) {
        User userChangePassword = userRepository.findUserById(userPass.getUserId());
        userChangePassword.setPassword(passwordEncoder.encode(userPass.getPassword()));
        userChangePassword.setUpdatedAt(Instant.now());
        userRepository.save(userChangePassword);
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
