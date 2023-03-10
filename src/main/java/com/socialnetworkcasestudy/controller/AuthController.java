package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.dto.SignUpDto;
import com.socialnetworkcasestudy.exception.ResourceAlreadyExistException;
import com.socialnetworkcasestudy.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin
public class AuthController {
    @Autowired
    private AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<SignUpDto> signUp(@RequestBody SignUpDto signUpDto) {
        authService.signUp(signUpDto);
        return new ResponseEntity<>(signUpDto, HttpStatus.CREATED);
    }

}
