package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.SignUpDto;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

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
}
