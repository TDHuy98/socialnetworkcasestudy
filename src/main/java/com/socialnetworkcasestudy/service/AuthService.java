package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.dto.UserDto;
import com.socialnetworkcasestudy.dto.authentication.AuthenticationRequest;
import com.socialnetworkcasestudy.dto.authentication.AuthenticationResponse;
import com.socialnetworkcasestudy.dto.authentication.RegisterRequest;
import com.socialnetworkcasestudy.model.User;

import java.util.Optional;

public interface AuthService {


    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);


    Optional<UserDto> getCurrentUser();

    void saveUserToken(User user, String jwtToken);

    void revokeAllUserTokens(User user);

    boolean checkEmailExisted(RegisterRequest request);

    boolean checkMobileExisted(RegisterRequest request);

    boolean checkUsernameExisted(RegisterRequest request);
}

