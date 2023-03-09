//package com.socialnetworkcasestudy.service.impl;
//
//import com.socialnetworkcasestudy.config.EncoderConfiguration;
//import com.socialnetworkcasestudy.config.JwtService;
//import com.socialnetworkcasestudy.controller.AuthenticationResponse;
//import com.socialnetworkcasestudy.dto.RegisterRequest;
//import com.socialnetworkcasestudy.model.Role;
//import com.socialnetworkcasestudy.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthenticationService {
//    @Autowired
//    private JwtService jwtService;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private EncoderConfiguration encoderConfiguration;
//
//    public AuthenticationResponse register(RegisterRequest request) {
//        var user = User.builder()
//                .username(request.getUsername())
//                .password(encoderConfiguration.passwordEncoder().encode(request.getPassword()))
//                .roles(String.valueOf(Role.USER))
//                .build();
//        userRepository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder().token(jwtToken).build();
//    }
//
//}
