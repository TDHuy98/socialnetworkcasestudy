package com.socialnetworkcasestudy.service.impl;

//import com.socialnetworkcasestudy.config.JwtService;

import com.socialnetworkcasestudy.config.EncoderConfiguration;
import com.socialnetworkcasestudy.dto.SignUpDto;
import com.socialnetworkcasestudy.model.Role;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
//    @Autowired
//    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public SignUpDto signUp(SignUpDto signUpDto) {
        User signUp = signUpDtoToUser(signUpDto);
        signUp.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        signUp.setCreatedAt(Instant.now());
        signUp.setRole(Role.USER);
        System.out.println(signUp);
        userRepository.save(signUp);
        return signUpDto;
    }

//    @Override
//    public String login(LoginRequest loginRequest) {
//        Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
//                loginRequest.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authenticate);
//        return jwtService.generateToken(authenticate);
//    }

    private String encodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    private User signUpDtoToUser(SignUpDto signUpDto) {
        User user = modelMapper.map(signUpDto, User.class);
        return user;
    }
}
