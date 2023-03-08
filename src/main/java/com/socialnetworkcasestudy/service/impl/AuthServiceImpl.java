package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.config.security.JwtProvider;
import com.socialnetworkcasestudy.dto.LoginRequest;
import com.socialnetworkcasestudy.dto.SignUpDto;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
//    private AuthenticationManager authenticationManager;
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public SignUpDto signUp(SignUpDto signUpDto) {
        User signUp = signUpDtoToUser(signUpDto);
        signUp.setCreatedAt(Instant.now());
        System.out.println(signUp);
        userRepository.save(signUp);
        return signUpDto;
    }

    private User signUpDtoToUser(SignUpDto signUpDto) {
        User user = modelMapper.map(signUpDto, User.class);
        return user;
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public String login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return jwtProvider.generateToken(authenticate);
    }

    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }
}
