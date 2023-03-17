package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.dto.CheckUserPass;
import com.socialnetworkcasestudy.dto.UserSetting;
import com.socialnetworkcasestudy.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUserName(String username);

    Optional<User> findById(Long id);
    User findUserById(Long id);

    UserSetting getUserUpdate(Long id);

    UserSetting updateUserInformation(UserSetting userSetting);

    boolean checkPasswordExisted(CheckUserPass checkUserPass);


    List<User> findAll();
}
