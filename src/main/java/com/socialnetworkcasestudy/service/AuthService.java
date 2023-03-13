package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.dto.SignUpDto;
import com.socialnetworkcasestudy.dto.authentication.AuthenticationRequest;
import com.socialnetworkcasestudy.dto.authentication.AuthenticationResponse;
import com.socialnetworkcasestudy.dto.authentication.RegisterRequest;
import com.socialnetworkcasestudy.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface AuthService {


    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    Optional<UserDetails> getCurrentUser();

    void saveUserToken(User user, String jwtToken);

    void revokeAllUserTokens(User user);

    boolean checkEmailExisted(RegisterRequest request);

    boolean checkMobileExisted(RegisterRequest request);

    boolean checkUsernameExisted(RegisterRequest request);
}

