package com.socialnetworkcasestudy.service.impl;


import com.socialnetworkcasestudy.dto.SignUpDto;
import com.socialnetworkcasestudy.exception.ResourceAlreadyExistException;
import com.socialnetworkcasestudy.model.Role;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
public class AuthServiceImpl{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public SignUpDto signUp(SignUpDto signUpDto) {
        if (checkUsernameExisted(signUpDto) && checkEmailExisted(signUpDto) && checkMobileExisted(signUpDto)) {
            throw new ResourceAlreadyExistException("These mobile, email and username have already registed");
        } else if (checkEmailExisted(signUpDto)) {
            throw new ResourceAlreadyExistException("This email has already registed");
        } else if (checkMobileExisted(signUpDto)) {
            throw new ResourceAlreadyExistException("This mobile has already registed");
        } else if (checkUsernameExisted(signUpDto)) {
            throw new ResourceAlreadyExistException("This username has already registed");
        }

        User signUp = signUpDtoToUser(signUpDto);
        signUp.setPassword(signUpDto.getPassword());
        signUp.setCreatedAt(Instant.now());
        signUp.setRole(Role.USER);
        System.out.println(signUp);
        userRepository.save(signUp);
        return signUpDto;
    }

    private boolean checkEmailExisted(SignUpDto signUpDto) {
        return userRepository.findUserByEmail(signUpDto.getEmail()).isPresent();
    }

    private boolean checkMobileExisted(SignUpDto signUpDto) {
        return userRepository.findUserByMobile(signUpDto.getMobile()).isPresent();
    }

    private boolean checkUsernameExisted(SignUpDto signUpDto) {
        return userRepository.findUserByUsername(signUpDto.getUsername()).isPresent();
    }

    private User signUpDtoToUser(SignUpDto signUpDto) {
        return modelMapper.map(signUpDto, User.class);
    }
}
