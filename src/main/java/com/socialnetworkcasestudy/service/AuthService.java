package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.dto.SignUpDto;
import com.socialnetworkcasestudy.model.User;

import java.util.List;

public interface AuthService {
    List<User> getAll();

    SignUpDto signUp(SignUpDto signUpDto);
}

