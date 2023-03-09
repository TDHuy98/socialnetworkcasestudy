package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.dto.LoginRequest;
import com.socialnetworkcasestudy.dto.SignUpDto;
import com.socialnetworkcasestudy.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AuthService {
    List<User> getAll();

    SignUpDto signUp(SignUpDto signUpDto);

//    String login(LoginRequest loginRequest);

//    Object register(RegisterRequest request);
}

